package org.esgi.trademe.contractor.domain;



import org.esgi.trademe.kernel.hash.HashEngine;
import org.esgi.trademe.kernel.hash.SHA256Engine;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public final class ContractorCredentials {

    private final static HashEngine HASH = new SHA256Engine();
    private String username;
    private String password;

    private ContractorCredentials(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    public static ContractorCredentials of(String username, String password) throws NoSuchAlgorithmException {
        ContractorCredentials credentials = new ContractorCredentials(username, password);
        credentials.password = HASH.encrypt(credentials.getPassword());
        return credentials;
    }

    public static ContractorCredentials nullCredentials() {
        return new ContractorCredentials("", "");
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
