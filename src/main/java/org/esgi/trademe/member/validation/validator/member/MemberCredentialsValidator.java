package org.esgi.trademe.member.validation.validator.member;


import org.esgi.trademe.member.domain.MemberCredentials;

public class MemberCredentialsValidator {
    private final MemberCredentials credentials;

    private MemberCredentialsValidator(MemberCredentials credentials) {
        this.credentials = credentials;
    }

    public static MemberCredentialsValidator of(MemberCredentials credentials) {
        return new MemberCredentialsValidator(credentials);
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
