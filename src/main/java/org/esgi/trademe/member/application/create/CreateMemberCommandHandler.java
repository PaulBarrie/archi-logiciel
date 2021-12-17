package org.esgi.trademe.member.application.create;


import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.*;
import org.esgi.trademe.member.validation.credentials.MemberCredentialsDataHandler;
import org.esgi.trademe.member.validation.credentials.UsernameUnicityHandler;
import org.esgi.trademe.member.validation.member.MemberDataHandler;
import org.esgi.trademe.member.validation.MemberHandler;
import org.esgi.trademe.member.validation.member.MemberUnicityHandler;


import java.security.NoSuchAlgorithmException;

public final class CreateMemberCommandHandler implements CommandHandler<CreateMember, Member> {
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final MemberHandler handler;

    private CreateMemberCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
        this.handler  = new MemberDataHandler();
        handler.setNext(new MemberUnicityHandler(memberRepository))
                .setNext(new MemberCredentialsDataHandler())
                .setNext(new UsernameUnicityHandler(memberRepository));

    }

    public static CreateMemberCommandHandler of(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new CreateMemberCommandHandler(memberRepository, eventEventDispatcher);
    }

    public Member handle(CreateMember createMember) throws NoSuchAlgorithmException, InvalidEntryException {
        final MemberID memberID = memberRepository.nextIdentity();
        Member member =  Member.of(memberID, createMember.firstname, createMember.lastname, createMember.email, createMember.birth,
                MemberCredentials.of(createMember.credentials.getUsername(), createMember.credentials.getPassword()),
                MemberAddress.of(createMember.address.getStreetNumber(), createMember.address.getStreetName(), createMember.address.getZipCode(),
                        createMember.address.getCity(), createMember.address.getCountry()));
        handler.check(member);
        memberRepository.add(member);
        eventEventDispatcher.dispatch(new CreateMemberEvent(memberID));
        return member;
    }
}
