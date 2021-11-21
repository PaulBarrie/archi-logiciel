package membership.common.user;


import membership.common.payment.Payment;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String birth;
    private final String email;
    private final Credentials credentials;
    private final Payment payment;

    private User(String firstName, String lastName, String birth, String email, Credentials credentials, Payment payment) {
        this.id = UUID.randomUUID().toString();
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.birth = Objects.requireNonNull(birth);
        this.email = Objects.requireNonNull(email);
        this.credentials = credentials;
        this.payment = payment;
    }

    public static User of(String firstName, String lastName, String birth, String email, Credentials credentials, Payment payment) {
        return new User(firstName, lastName, birth, email, credentials, payment);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Payment getPayment() {
        return payment;
    }
}
