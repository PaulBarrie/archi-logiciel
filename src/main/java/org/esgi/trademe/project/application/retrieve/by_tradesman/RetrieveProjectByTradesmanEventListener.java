package org.esgi.trademe.project.application.retrieve.by_tradesman;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveProjectByTradesmanEventListener implements EventListener<RetrieveProjectByTradesmanEvent> {
    @Override
    public void listenTo(RetrieveProjectByTradesmanEvent event) {
        System.out.println("listening RetrieveProjectByTradesmanEvent.");
    }
}
