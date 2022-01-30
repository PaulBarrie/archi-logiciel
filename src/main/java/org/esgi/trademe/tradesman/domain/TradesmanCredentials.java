package org.esgi.trademe.tradesman.domain;



import org.esgi.trademe.kernel.hash.HashEngine;
import org.esgi.trademe.kernel.hash.SHA256Engine;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class TradesmanCredentials {

    private final static HashEngine HASH = new SHA256Engine();
    private String username;
    private String password;

    private TradesmanCredentials(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    public static TradesmanCredentials of(String username, String password) throws NoSuchAlgorithmException {
        TradesmanCredentials credentials = new TradesmanCredentials(username, password);
        credentials.password = HASH.encrypt(credentials.getPassword());
        return credentials;
    }

    public static TradesmanCredentials nullCredentials() {
        return new TradesmanCredentials("", "");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
