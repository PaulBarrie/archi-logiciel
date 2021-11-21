package membership.service;

import membership.builder.Director;
import membership.builder.UserBuilder;
import membership.builder.UserWithPaypalBuilder;
import membership.common.payment.PaymentType;
import membership.common.user.User;
import membership.handler.payment.paypal.PaypalPaymentHandler;
import membership.handler.payment.paypal.PaypalPaymentNotNullHandler;

import java.util.Map;

public class MembershipWithPaypalService extends MembershipService {

    private Director director;
    private UserBuilder builder;

    public MembershipWithPaypalService() {
        this.builder = new UserWithPaypalBuilder();
        PaypalPaymentHandler paymentHandler = new PaypalPaymentNotNullHandler();
        this.director = new Director(this.builder, this.userHandler, this.credentialsHandler, paymentHandler);
    }

    @Override
    public User registerUser(Map<String, String> userDetails, Map<String, String> credentialsDetails,
                             Map<String, String> paymentDetails) {
        User user = this.director.makeUser(userDetails, credentialsDetails, PaymentType.CB, paymentDetails);
        System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() + "!");
        return user;
    }

}
