package org.esgi.trademe.member.domain;



import org.esgi.trademe.kernel.hash.HashEngine;
import org.esgi.trademe.kernel.hash.SHA256Engine;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public final class MemberCredentials {

    private final static HashEngine HASH = new SHA256Engine();
    private String username;
    private String password;

    private MemberCredentials(String username, String password) {
        this.username = Objects.requireNonNull(username);
        this.password = Objects.requireNonNull(password);
    }

    public static MemberCredentials of(String username, String password) throws NoSuchAlgorithmException {
        MemberCredentials credentials = new MemberCredentials(username, password);
        credentials.password = HASH.encrypt(credentials.getPassword());
        return credentials;
    }

    public static MemberCredentials nullCredentials() {
        return new MemberCredentials("", "");
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
