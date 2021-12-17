package org.esgi.trademe.member.domain;

import org.esgi.trademe.kernel.Repository;

import java.util.List;

public interface MemberRepository extends Repository<MemberID, Member> {
    List<Member> findAll();
    List<Member> findByCity(String city);
}
