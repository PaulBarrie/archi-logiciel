package org.esgi.trademe.project.application.retrieve.by_contractor;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveProjectByContractorEventListener implements EventListener<RetrieveProjectByContractorEvent> {
    @Override
    public void listenTo(RetrieveProjectByContractorEvent event) {
        System.out.println("listening RetrieveProjectByContractorEvent.");
    }
}
