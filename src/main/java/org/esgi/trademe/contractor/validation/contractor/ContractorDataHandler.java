package org.esgi.trademe.contractor.validation.contractor;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.validation.ContractorHandler;
import org.esgi.trademe.contractor.validation.validator.contractor.ContractorValidator;

public final class ContractorDataHandler extends ContractorHandler {
    @Override
    public void check(Contractor contractor) throws InvalidEntryException {
        ContractorValidator validator =  new ContractorValidator();
        validator.isValid(contractor);
        checkNext(contractor);
    }

}
