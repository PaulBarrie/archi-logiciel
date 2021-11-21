package membership.service;

import membership.builder.Director;
import membership.builder.UserBuilder;
import membership.builder.UserWithCBBuilder;
import membership.common.payment.PaymentType;
import membership.common.user.User;
import membership.handler.credentials.CredentialsDataHandler;
import membership.handler.credentials.CredentialsHandler;
import membership.handler.credentials.UsernameUnicityHandler;
import membership.handler.payment.cb.CBPaymentHandler;
import membership.handler.payment.cb.CBPaymentNotNullHandler;
import membership.handler.user.UserDataHandler;
import membership.handler.user.UserHandler;
import membership.handler.user.UserUnicityHandler;

import java.util.Map;

public final class MembershipWithCBService extends MembershipService {
    private Director director;
    private UserBuilder builder;

    public MembershipWithCBService() {
        this.builder = new UserWithCBBuilder();
        CBPaymentHandler paymentHandler = new CBPaymentNotNullHandler();

        this.director = new Director(this.builder, super.userHandler, super.credentialsHandler, paymentHandler);
    }

    @Override
    public User registerUser(Map<String, String> userDetails, Map<String, String> credentialsDetails,
                             Map<String, String> paymentDetails) {
        User user = this.director.makeUser(userDetails, credentialsDetails, PaymentType.CB, paymentDetails);
        System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() + "!");
        return user;
    }
}


