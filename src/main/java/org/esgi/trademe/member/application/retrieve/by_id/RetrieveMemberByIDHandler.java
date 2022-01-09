package org.esgi.trademe.member.application.retrieve.by_id;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.member.domain.MemberRepository;
import org.esgi.trademe.member.exposition.MemberDTO;

public final class RetrieveMemberByIDHandler implements QueryHandler<RetrieveMemberByID,MemberDTO> {

    private final MemberRepository memberRepository;

    public RetrieveMemberByIDHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDTO handle(RetrieveMemberByID query) {
        return MemberDTO.of(memberRepository.findById(query.id));

    }
}
