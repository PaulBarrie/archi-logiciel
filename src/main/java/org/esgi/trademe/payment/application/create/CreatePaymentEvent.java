package org.esgi.trademe.payment.application.create;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.payment.domain.PaymentID;

public class CreatePaymentEvent implements ApplicationEvent {
    private final PaymentID paymentID;

    public CreatePaymentEvent(PaymentID paymentID) {
        this.paymentID = paymentID;
    }

    public static CreatePaymentEvent of(PaymentID paymentID) {
        return new CreatePaymentEvent(paymentID);
    }
}
