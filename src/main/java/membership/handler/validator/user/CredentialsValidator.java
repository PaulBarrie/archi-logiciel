package membership.handler.validator.user;


import membership.common.user.Credentials;

public class CredentialsValidator {
    private final Credentials credentials;

    private CredentialsValidator(Credentials credentials) {
        this.credentials = credentials;
    }

    public static CredentialsValidator of(Credentials credentials) {
        return new CredentialsValidator(credentials);
    }

    public String isValid() {
        if(credentials.getUsername().length() == 0) {
            return  "Invalid username";
        }
        if(!credentials.getPassword().matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            return "Invalid password: Must be at least 8 char long and contain 1 uppercase, 1 lowercase, 1 number, 1 special char.";
        }
        return null;
    }
}
