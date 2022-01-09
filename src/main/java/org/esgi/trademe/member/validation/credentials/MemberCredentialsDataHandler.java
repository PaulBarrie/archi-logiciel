package org.esgi.trademe.member.validation.credentials;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.validation.MemberHandler;
import org.esgi.trademe.member.validation.validator.member.MemberCredentialsValidator;


public final class MemberCredentialsDataHandler extends MemberHandler {
    @Override
    public void check(Member entity) throws InvalidEntryException {
        MemberCredentialsValidator validator = MemberCredentialsValidator.of(entity.getCredentials());
        validator.isValid();
        checkNext(entity);
    }
}
