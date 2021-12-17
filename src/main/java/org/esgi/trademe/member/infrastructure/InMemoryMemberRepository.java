package org.esgi.trademe.member.infrastructure;


import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.domain.MemberID;
import org.esgi.trademe.member.domain.MemberRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryMemberRepository implements MemberRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MemberID, Member> data = new ConcurrentHashMap<>();

    @Override
    public MemberID nextIdentity() {
        return  MemberID.of(count.incrementAndGet());
    }

    @Override
    public Member findById(MemberID id) {
        final Member user = data.get(id);
        if (user == null) {
            throw NoSuchEntityException.withId(id);
        }
        return user;
    }

    @Override
    public void add(Member member) {
        data.put(member.getId(), member);
    }

    @Override
    public void delete(MemberID id) {
        data.remove(id);
    }

    @Override
    public List<Member> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public List<Member> findByCity(String city) {
        return List.copyOf(data.values().stream()
                .filter(member -> member.getAddress().getCity().equals(city)).collect(Collectors.toList()));
    }
}
