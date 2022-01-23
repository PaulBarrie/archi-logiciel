package org.esgi.trademe.trademan.application.retrieve.search;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveTradesmanByEducationEventListener implements EventListener<RetrieveTradesmanByEducationEvent> {
    @Override
    public void listenTo(RetrieveTradesmanByEducationEvent event) {
        System.out.println("listening RetrieveTradesmanByEducationEvent.");
    }
}
