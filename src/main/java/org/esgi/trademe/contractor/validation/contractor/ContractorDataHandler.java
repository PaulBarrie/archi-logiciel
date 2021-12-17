package org.esgi.trademe.contractor.validation.contractor;

import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.validation.ContractorHandler;
import org.esgi.trademe.contractor.validation.validator.contractor.ContractorValidator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


public final class ContractorDataHandler extends ContractorHandler {
    @Override
    public void check(Contractor contractor) throws InvalidEntryException {
        ContractorValidator validator =  new ContractorValidator();
        validator.isValid(contractor);
        checkNext(contractor);
    }

}
