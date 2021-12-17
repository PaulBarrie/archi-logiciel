package org.esgi.trademe.member.validation;


import org.esgi.trademe.kernel.Handler;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.Member;


public abstract class MemberHandler implements Handler<Member> {
    private MemberHandler next;

    @Override
    public abstract void check(Member member) throws InvalidEntryException;

    @Override
    public Handler<Member> setNext(Handler<Member> next) {
        this.next = (MemberHandler) next;
        return next;
    }

    @Override
    public void checkNext(Member member) throws InvalidEntryException {
        if (next != null) {
            next.check(member);
        }
    }
}
