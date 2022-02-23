package org.esgi.trademe.tradesman.validation.tradesman;

import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.tradesman.validation.TradesmanHandler;
import org.esgi.trademe.tradesman.validation.validator.tradesman.TradesmanValidator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


public final class TradesmanDataHandler extends TradesmanHandler {
    @Override
    public void check(Tradesman tradesman) throws InvalidEntryException {
        TradesmanValidator validator =  new TradesmanValidator();
        validator.isValid(tradesman);
        checkNext(tradesman);
    }

}
