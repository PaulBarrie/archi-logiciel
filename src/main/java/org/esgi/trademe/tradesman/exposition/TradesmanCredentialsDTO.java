package org.esgi.trademe.tradesman.exposition;

public final class TradesmanCredentialsDTO {
    private final String username;
    private final String password;

    private TradesmanCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static TradesmanCredentialsDTO of(String username, String password) {
        return new TradesmanCredentialsDTO(username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CredentialsDTO{" +
                "username='" + username + '\'' +
                "password='" + password + '\'' +
                '}';
    }

}
