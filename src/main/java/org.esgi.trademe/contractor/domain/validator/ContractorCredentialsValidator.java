package org.esgi.trademe.contractor.domain.validator;


import org.esgi.trademe.kernel.validator.Validator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.contractor.domain.ContractorCredentials;


public final class ContractorCredentialsValidator implements Validator<ContractorCredentials> {
    @Override
    public void isValid(ContractorCredentials entity) throws InvalidEntryException {
        if (entity.getUsername().length() == 0) {
            throw InvalidEntryException.unprovided("Username");
        }
        if (!entity.getPassword().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            throw new InvalidEntryException("Invalid password: Must be at least 8 char long and contain 1 uppercase, 1 lowercase, 1 number, 1 special char.");
        }
    }
}
