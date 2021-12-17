package org.esgi.trademe.member.exposition;


public final class MemberCredentialsDTO {
    private final String username;
    private final String password;

    private MemberCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static MemberCredentialsDTO of(String username, String password) {
        return new MemberCredentialsDTO(username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CredentialsDTO {" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                "}";
    }
}
