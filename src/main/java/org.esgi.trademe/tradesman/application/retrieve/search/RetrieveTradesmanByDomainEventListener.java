package org.esgi.trademe.tradesman.application.retrieve.search;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveTradesmanByDomainEventListener implements EventListener<RetrieveTradesmanByDomainEvent> {
    @Override
    public void listenTo(RetrieveTradesmanByDomainEvent event) {
        System.out.println("listening RetrieveTradesmanByEducationEvent.");
    }
}
