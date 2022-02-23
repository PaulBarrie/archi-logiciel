package org.esgi.trademe.payment.application.update;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.payment.domain.PaymentID;

public final class UsePaymentEvent implements ApplicationEvent {
    private final PaymentID paymentID;

    public UsePaymentEvent(PaymentID paymentID) {
        this.paymentID = paymentID;
    }

    public static UsePaymentEvent of(PaymentID paymentID) {
        return new UsePaymentEvent(paymentID);
    }
}
