package org.esgi.trademe.contract.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveContractByIDEventListener implements EventListener<RetrieveContractByIDEvent> {
    @Override
    public void listenTo(RetrieveContractByIDEvent event) {
        System.out.println("listening RetrieveContractByIDEvent.");
    }
}
