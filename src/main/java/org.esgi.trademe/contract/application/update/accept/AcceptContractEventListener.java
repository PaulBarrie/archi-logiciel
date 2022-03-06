package org.esgi.trademe.contract.application.update.accept;


import org.esgi.trademe.kernel.event.EventListener;

public final class AcceptContractEventListener implements EventListener<AcceptContractEvent> {
    @Override
    public void listenTo(AcceptContractEvent event) {
        System.out.println("listening CreateContractorEvent.");
    }
}
