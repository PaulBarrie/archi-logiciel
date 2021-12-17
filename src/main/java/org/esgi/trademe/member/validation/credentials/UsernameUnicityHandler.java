package org.esgi.trademe.member.validation.credentials;

import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.kernel.exceptions.AlreadyUsedParameterException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.domain.MemberRepository;
import org.esgi.trademe.member.validation.MemberHandler;

import java.util.List;
import java.util.Objects;

public class UsernameUnicityHandler extends MemberHandler {
    private MemberHandler next;
    private final MemberRepository memberRepository;

    public UsernameUnicityHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void check(Member entity) throws InvalidEntryException {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            if (Objects.equals(member.getCredentials().getUsername(), entity.getCredentials().getUsername())) {
                throw AlreadyUsedParameterException.with("Username", entity.getCredentials().getUsername());
            }
        }
        checkNext(entity);
    }
}
