package org.esgi.trademe.member.application.update;


import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.member.domain.MemberAddress;
import org.esgi.trademe.member.domain.MemberID;
import org.esgi.trademe.member.domain.MemberRepository;

public final class ModifyMemberAddressCommandHandler implements CommandHandler<ModifyMemberAddress, Void> {

    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyMemberAddressCommandHandler(MemberRepository memberRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.memberRepository = memberRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyMemberAddress command) {
        var memberId =  MemberID.of(command.memberId);
        var member = memberRepository.findById(memberId);
        var address =  MemberAddress.of(command.address.getStreetNumber(), command.address.getStreetNumber(),
                command.address.getZipCode(), command.address.getCity(), command.address.getCountry());
        member.changeAddress(address);
        memberRepository.add(member);
        eventEventDispatcher.dispatch(new ModifyMemberAddressEvent(memberId));
        return null;
    }
}
