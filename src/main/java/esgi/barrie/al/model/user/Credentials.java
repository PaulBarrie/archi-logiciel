package esgi.barrie.cc1.model.user;

import esgi.barrie.cc1.model.validators.user.CredentialsValidator;
import esgi.barrie.cc1.service.hash.Hash;
import esgi.barrie.cc1.service.hash.SHA256;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Credentials {
    private final String username;
    private String password;
    private final static Hash hash = new SHA256();

    private Credentials(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    public static Credentials of(String username, String password) throws NoSuchAlgorithmException {
        Credentials credentials = new Credentials(username, password);
        CredentialsValidator.of(credentials).check();
        credentials.password = hash.encrypt(credentials.getPassword());
        return credentials;
    }

    public static Credentials nullCredentials() {
        return new Credentials(null, null);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
