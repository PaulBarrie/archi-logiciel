package org.esgi.trademe.tradesman.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveTradesmanByIDEventListener implements EventListener<RetrieveTradesmanByIDEvent> {
    @Override
    public void listenTo(RetrieveTradesmanByIDEvent event) {
        System.out.println("listening RetrieveTradesmanByIDEvent.");
    }
}
