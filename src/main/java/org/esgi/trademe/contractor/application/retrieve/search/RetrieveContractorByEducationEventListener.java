package org.esgi.trademe.contractor.application.retrieve.search;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveContractorByEducationEventListener implements EventListener<RetrieveContractorByEducationEvent> {
    @Override
    public void listenTo(RetrieveContractorByEducationEvent event) {
        System.out.println("listening RetrieveContractorByEducationEvent.");
    }
}
