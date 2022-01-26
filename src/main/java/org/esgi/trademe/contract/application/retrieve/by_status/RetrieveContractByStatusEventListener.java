package org.esgi.trademe.contract.application.retrieve.by_status;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveContractByStatusEventListener implements EventListener<RetrieveContractByStatusEvent> {
    @Override
    public void listenTo(RetrieveContractByStatusEvent event) {
        System.out.println("listening RetrieveContractByStatusEvent.");
    }
}
