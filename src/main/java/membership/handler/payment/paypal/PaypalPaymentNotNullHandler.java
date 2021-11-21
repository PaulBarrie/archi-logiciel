package membership.handler.payment.paypal;

import membership.common.payment.Payment;
import membership.common.payment.PaypalPayment;



public class PaypalPaymentNotNullHandler extends PaypalPaymentHandler {
    private PaypalPayment next;

    @Override
    public String check(Payment payment) {
        PaypalPayment paypalPayment = (PaypalPayment) payment;
        if(paypalPayment.getPaypalUserName() == null) {
            return "Paypal username should be provided.";
        }
        if(paypalPayment.getPaypalAuthToken() == null) {
            return "Paypal auth token should be provided.";
        }
        return this.checkNext(paypalPayment);
    }
}
