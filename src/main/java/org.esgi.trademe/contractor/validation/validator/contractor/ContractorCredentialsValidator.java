package org.esgi.trademe.contractor.validation.validator.contractor;


import org.esgi.trademe.contractor.domain.ContractorCredentials;

public final class ContractorCredentialsValidator {
    private final ContractorCredentials credentials;

    private ContractorCredentialsValidator(ContractorCredentials credentials) {
        this.credentials = credentials;
    }

    public static ContractorCredentialsValidator of(ContractorCredentials credentials) {
        return new ContractorCredentialsValidator(credentials);
    }

    public String isValid() {
        if (credentials.getUsername().length() == 0) {
            return "Invalid username";
        }
        if (!credentials.getPassword().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            return "Invalid password: Must be at least 8 char long and contain 1 uppercase, 1 lowercase, 1 number, 1 special char.";
        }
        return null;
    }
}
