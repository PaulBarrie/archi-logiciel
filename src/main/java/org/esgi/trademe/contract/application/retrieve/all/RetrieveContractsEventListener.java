package org.esgi.trademe.contract.application.retrieve.all;


import org.esgi.trademe.kernel.event.EventListener;

public final class RetrieveContractsEventListener implements EventListener<RetrieveContractsEvent> {
    @Override
    public void listenTo(RetrieveContractsEvent event) {
        System.out.println("listening RetrieveContractsEvent.");
    }
}
