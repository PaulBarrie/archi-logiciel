package membership.builder;

import membership.common.payment.Payment;
import membership.common.user.Credentials;
import membership.common.user.User;

public interface UserBuilder {
    void setFirstname(String firstname);
    void setLastname(String lastname);
    void setBirth(String birth);
    void setEmail(String email);
    void setCredentials(Credentials credentials);
    void setPayment(Payment payment);
    User getResult();
}
