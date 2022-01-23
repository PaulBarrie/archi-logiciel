package org.esgi.trademe.trademan.application.retrieve.all;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveTradesmenEventListener implements EventListener<RetrieveTradesmenEvent> {
    @Override
    public void listenTo(RetrieveTradesmenEvent event) {
        System.out.println("listening RetrieveTradesmanEvent.");
    }
}
