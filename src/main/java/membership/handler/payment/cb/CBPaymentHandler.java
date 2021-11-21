package membership.handler.payment.cb;

import membership.common.payment.CBPayment;
import membership.handler.payment.PaymentHandler;

public abstract class CBPaymentHandler extends PaymentHandler {
    private CBPaymentHandler next;

    public CBPaymentHandler setNext(CBPaymentHandler next) {
        this.next = next;
        return next;
    }

    public String checkNext(CBPayment payment) {
        if (next == null) {
            return null;
        }
        return next.check(payment);
    }

}
