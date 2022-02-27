package org.esgi.trademe.contractor.validation.credentials;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.validation.ContractorHandler;
import org.esgi.trademe.contractor.validation.validator.contractor.ContractorCredentialsValidator;


public final class ContractorCredentialsDataHandler extends ContractorHandler {
    @Override
    public void check(Contractor entity) throws InvalidEntryException {
        ContractorCredentialsValidator validator = ContractorCredentialsValidator.of(entity.getCredentials());
        validator.isValid();
        checkNext(entity);
    }
}
