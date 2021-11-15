package esgi.barrie.al.model.user;

import esgi.barrie.al.model.validators.user.CredentialsValidator;
import esgi.barrie.al.service.hash.Hash;
import esgi.barrie.al.service.hash.SHA256;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Credentials {

    private String username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
