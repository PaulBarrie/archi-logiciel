package org.esgi.trademe.trademan.validation.tradesman;

import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.validation.TradesmanHandler;
import org.esgi.trademe.trademan.validation.validator.tradesman.TradesmanValidator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


public final class TradesmanDataHandler extends TradesmanHandler {
    @Override
    public void check(Tradesman tradesman) throws InvalidEntryException {
        TradesmanValidator validator =  new TradesmanValidator();
        validator.isValid(tradesman);
        checkNext(tradesman);
    }

}
