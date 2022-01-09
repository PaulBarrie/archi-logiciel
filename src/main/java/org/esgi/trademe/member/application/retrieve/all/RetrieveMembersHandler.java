package org.esgi.trademe.member.application.retrieve.all;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.member.domain.MemberRepository;
import org.esgi.trademe.member.exposition.MemberDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class RetrieveMembersHandler implements QueryHandler<RetrieveMembers, List<MemberDTO>> {

    private final MemberRepository memberRepository;

    public RetrieveMembersHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDTO> handle(RetrieveMembers query) {
        return memberRepository.findAll()
                .stream()
                .map(MemberDTO::of)
                .collect(Collectors.toList());
    }
}
