package org.esgi.trademe.project.application.retrieve.by_status;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveProjectByStatusEventListener implements EventListener<RetrieveProjectByStatusEvent> {
    @Override
    public void listenTo(RetrieveProjectByStatusEvent event) {
        System.out.println("listening RetrieveProjectByStatusEvent.");
    }
}
