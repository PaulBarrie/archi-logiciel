package org.esgi.trademe.member.validation.member;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.validation.MemberHandler;
import org.esgi.trademe.member.validation.validator.member.MemberValidator;

public final class MemberDataHandler extends MemberHandler {
    @Override
    public void check(Member member) throws InvalidEntryException {
        MemberValidator validator =  new MemberValidator();
        validator.isValid(member);
        checkNext(member);
    }

}
