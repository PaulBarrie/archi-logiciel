package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveProjectByIDEventListener implements EventListener<RetrieveProjectByIDEvent> {
    @Override
    public void listenTo(RetrieveProjectByIDEvent event) {
        System.out.println("listening RetrieveContractByIDEvent.");
    }
}
