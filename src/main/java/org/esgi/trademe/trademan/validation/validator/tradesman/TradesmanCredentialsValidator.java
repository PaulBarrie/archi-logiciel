package org.esgi.trademe.trademan.validation.validator.tradesman;


import org.esgi.trademe.trademan.domain.TradesmanCredentials;


public final class TradesmanCredentialsValidator {
    private final TradesmanCredentials credentials;

    private TradesmanCredentialsValidator(TradesmanCredentials credentials) {
        this.credentials = credentials;
    }

    public static TradesmanCredentialsValidator of(TradesmanCredentials credentials) {
        return new TradesmanCredentialsValidator(credentials);
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
