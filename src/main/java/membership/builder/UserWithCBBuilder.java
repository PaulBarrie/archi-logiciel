package membership.builder;

import membership.common.payment.CBPayment;
import membership.common.payment.Payment;
import membership.common.user.Credentials;
import membership.common.user.User;

public class UserWithCBBuilder implements UserBuilder {
    private String firstname;
    private String lastname;
    private String birth;
    private String email;
    private Credentials credentials;
    private CBPayment payment;

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public void setPayment(Payment payment) {
        this.payment=(CBPayment) payment;
    }

    @Override
    public User getResult() {
        return User.of(this.firstname, this.lastname, this.birth, this.email, this.credentials, this.payment);
    }
}
