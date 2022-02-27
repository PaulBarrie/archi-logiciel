package org.esgi.trademe.tradesman.application.create;


import org.esgi.trademe.kernel.event.EventListener;

public final class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    @Override
    public void listenTo(CreateTradesmanEvent event) {
        System.out.println("listening CreateTradesmanEvent.");
    }
}
