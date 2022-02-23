package org.esgi.trademe.payment.application.create;


import org.esgi.trademe.kernel.event.EventListener;

public class CreatePaymentEventListener implements EventListener<CreatePaymentEvent> {
    @Override
    public void listenTo(CreatePaymentEvent event) {
        System.out.println("listening CreatePaymentEvent.");
    }
}
