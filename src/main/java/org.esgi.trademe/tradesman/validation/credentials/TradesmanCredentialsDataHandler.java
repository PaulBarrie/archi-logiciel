package org.esgi.trademe.tradesman.validation.credentials;

import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.tradesman.validation.TradesmanHandler;
import org.esgi.trademe.tradesman.validation.validator.tradesman.TradesmanCredentialsValidator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


public final class TradesmanCredentialsDataHandler extends TradesmanHandler {
    @Override
    public void check(Tradesman entity) throws InvalidEntryException {
        TradesmanCredentialsValidator validator = TradesmanCredentialsValidator.of(entity.getCredentials());
        validator.isValid();
        checkNext(entity);
    }
}
