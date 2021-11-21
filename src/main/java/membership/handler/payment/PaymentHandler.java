package membership.handler.payment;


import membership.common.payment.Payment;

public abstract class PaymentHandler {
    private PaymentHandler next;
    public abstract String check(Payment payment);


    public String checkNext(Payment payment) {
        if (next == null) {
            return null;
        }
        return next.check(payment);
    }
}
