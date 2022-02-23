package org.esgi.trademe.payment.application.update;


import org.esgi.trademe.kernel.event.EventListener;

public final class UsePaymentEventListener implements EventListener<UsePaymentEvent> {
    @Override
    public void listenTo(UsePaymentEvent event) {
        System.out.println("listening CreatePaymentEvent.");
    }
}
