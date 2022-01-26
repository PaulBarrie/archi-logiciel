package org.esgi.trademe.contract.application.retrieve.by_tradesman;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveContractByTradesmanEventListener implements EventListener<RetrieveContractByTradesmanEvent> {
    @Override
    public void listenTo(RetrieveContractByTradesmanEvent event) {
        System.out.println("listening RetrieveContractByTradesmanEvent.");
    }
}
