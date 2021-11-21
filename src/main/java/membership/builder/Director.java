package membership.builder;

import membership.common.payment.CBPayment;
import membership.common.payment.PaymentType;
import membership.common.payment.PaypalPayment;
import membership.common.user.Credentials;
import membership.common.user.User;
import membership.handler.credentials.CredentialsHandler;
import membership.handler.payment.PaymentHandler;
import membership.handler.payment.paypal.PaypalPaymentHandler;
import membership.handler.payment.paypal.PaypalPaymentNotNullHandler;
import membership.handler.user.UserHandler;

import java.util.Map;
import java.util.Objects;

public class Director {
    UserBuilder builder;
    UserHandler userHandler;
    CredentialsHandler credentialsHandler;
    PaymentHandler paymentHandler;


    public Director(UserBuilder builder, UserHandler userHandler, CredentialsHandler credentialsHandler, PaymentHandler paymentHandler) {
        this.builder = builder;
        this.userHandler = userHandler;
        this.credentialsHandler = credentialsHandler;
        this.paymentHandler = paymentHandler;
    }

    PaypalPaymentHandler paypalPaymentHandler;

    public Director(UserBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(UserBuilder builder) {
        this.builder = builder;
    }

    public User makeUser(Map<String,String> userDetails, Map<String,String> credentialsDetails, PaymentType paymentType, Map<String,String> paymentDetails) throws IllegalArgumentException {
        extractUserDetails(userDetails);
        extractCredentialsDetails(credentialsDetails);

        if(paymentType == PaymentType.PAYPAL) {
            extractPaypalPaymentDetails(paymentDetails);
        } else if(paymentType == PaymentType.CB) {
            extractCBPaymentDetails(paymentDetails);
        } else {
            throw new IllegalArgumentException("Unsupported payment type.");
        }
        return this.builder.getResult();
    }

    private void extractUserDetails(Map<String,String> userDetails) throws IllegalArgumentException {
        for(Map.Entry<String,String> entry: userDetails.entrySet()) {
            if(Objects.equals(entry.getKey(), "firstname")) {
                this.builder.setFirstname(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "lastname")) {
                this.builder.setLastname(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "birth")) {
                this.builder.setBirth(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "email")) {
                this.builder.setEmail(entry.getValue());
            }
        }
        String resp = this.userHandler.check(this.builder.getResult());
        if(resp != null) {
            throw new IllegalArgumentException(resp);
        }
    }

    private void extractCredentialsDetails(Map<String,String> credentialsDetails) throws IllegalArgumentException {
        Credentials credentials = Credentials.nullCredentials();

        for(Map.Entry<String,String> entry: credentialsDetails.entrySet()) {
            if(Objects.equals(entry.getKey(), "username")) {
                credentials.setUsername(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "password")) {
                credentials.setPassword(entry.getValue());
            }
        }
        this.builder.setCredentials(credentials);
        String resp = this.credentialsHandler.check(this.builder.getResult().getCredentials());
        if(resp != null) {
            throw new IllegalArgumentException(resp);
        }
    }

    private void extractCBPaymentDetails(Map<String,String> paymentDetails) {
        CBPayment payment = CBPayment.nullPayment();

        for(Map.Entry<String,String> entry: paymentDetails.entrySet()) {
            if(Objects.equals(entry.getKey(), "card_number")) {
                payment.setOwnerName(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "card_number")) {
                payment.setCardNumber(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "expiration_date")) {
                payment.setExpirationDate(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "cvc")) {
                payment.setCVC(entry.getValue());
            }
        }
        this.builder.setPayment(payment);

        String resp = paymentHandler.check((this.builder.getResult().getPayment()));
        if(resp != null) {
            throw new IllegalArgumentException(resp);
        }
    }

    private void extractPaypalPaymentDetails(Map<String,String> paymentDetails) {
        PaypalPayment payment = PaypalPayment.nullPayment();
        PaypalPaymentHandler handler= new PaypalPaymentNotNullHandler();

        for(Map.Entry<String,String> entry: paymentDetails.entrySet()) {
            if(Objects.equals(entry.getKey(), "paypal_username")) {
                payment.setPaypalUserName(entry.getValue());
            }
            if(Objects.equals(entry.getKey(), "auth_token")) {
                payment.setPaypalAuthToken(entry.getValue());
            }
        }
        this.builder.setPayment(payment);
        String resp = handler.check((PaypalPayment) this.builder.getResult().getPayment());
        if(resp != null) {
            throw new IllegalArgumentException(resp);
        }
    }
}
