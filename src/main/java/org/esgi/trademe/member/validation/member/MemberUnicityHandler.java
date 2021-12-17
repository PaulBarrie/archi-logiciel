package org.esgi.trademe.member.validation.member;

import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.kernel.exceptions.AlreadyUsedParameterException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.domain.MemberRepository;
import org.esgi.trademe.member.validation.MemberHandler;


import java.util.List;
import java.util.Objects;

public final class MemberUnicityHandler extends MemberHandler {
    private final MemberRepository memberRepository;

    public MemberUnicityHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void check(Member member) throws InvalidEntryException {
        List<Member> existingMember = memberRepository.findAll();
        for (Member m : existingMember) {
            if (Objects.equals(member.getEmail(), m.getEmail())) {
                throw  AlreadyUsedParameterException.forField("Email", member.getEmail());
            }
            if (Objects.equals(member.getFirstname(), m.getFirstname()) & Objects.equals(member.getLastname(), m.getLastname()) && Objects.equals(m.getBirth(), m.getBirth())) {
                throw new AlreadyUsedParameterException("Member " + member.getFirstname() + " " + member.getLastname() + ", born in " + m.getBirth() + " already exists.");
            }
        }
        checkNext(member);
    }
}
