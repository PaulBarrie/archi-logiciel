package esgi.barrie.cc1.model.validators.user;

import esgi.barrie.cc1.model.user.Credentials;

public class CredentialsValidator {
    private final Credentials credentials;

    private CredentialsValidator(Credentials credentials) {
        this.credentials = credentials;
    }

    public static CredentialsValidator of(Credentials credentials) {
        return new CredentialsValidator(credentials);
    }

    public void check() throws IllegalArgumentException {
        if(credentials.getUsername().length() == 0) {
            throw new IllegalArgumentException("Invalid username");
        }
        if(!credentials.getPassword().matches("\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\"")) {
            throw new IllegalArgumentException("Invalid password: Must be at least 8 char long and contain 1 uppercase, 1 lowercase, 1 number, 1 special char.");
        }
    }
}
