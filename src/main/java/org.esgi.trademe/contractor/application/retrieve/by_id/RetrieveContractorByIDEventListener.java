package org.esgi.trademe.contractor.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveContractorByIDEventListener implements EventListener<RetrieveContractorByIDEvent> {
    @Override
    public void listenTo(RetrieveContractorByIDEvent event) {
        System.out.println("listening RetrieveContractorByIDEvent.");
    }
}
