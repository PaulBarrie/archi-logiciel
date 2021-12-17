package org.esgi.trademe.contractor.exposition;

public final class ContractorCredentialsDTO {
    private final String username;
    private final String password;

    private ContractorCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static ContractorCredentialsDTO of(String username, String password) {
        return new ContractorCredentialsDTO(username, password);
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
