package org.esgi.trademe.trademan.validation.credentials;

import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.validation.TradesmanHandler;
import org.esgi.trademe.trademan.validation.validator.tradesman.TradesmanCredentialsValidator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


public final class TradesmanCredentialsDataHandler extends TradesmanHandler {
    @Override
    public void check(Tradesman entity) throws InvalidEntryException {
        TradesmanCredentialsValidator validator = TradesmanCredentialsValidator.of(entity.getCredentials());
        validator.isValid();
        checkNext(entity);
    }
}
