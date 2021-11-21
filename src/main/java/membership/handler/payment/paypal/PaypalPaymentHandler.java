package membership.handler.payment.paypal;


import membership.common.payment.Payment;
import membership.common.payment.PaypalPayment;
import membership.handler.Handler;
import membership.handler.payment.PaymentHandler;


public abstract class PaypalPaymentHandler extends PaymentHandler {
    private PaypalPaymentHandler next;

    public abstract String check(Payment payment);
    protected PaypalPaymentHandler setNext(PaypalPaymentHandler next) {
        this.next = next;
        return this.next;
    }

}
