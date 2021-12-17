package org.esgi.trademe.contractor.application.retrieve.all;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveContractorsEventListener implements EventListener<RetrieveContractorsEvent> {
    @Override
    public void listenTo(RetrieveContractorsEvent event) {
        System.out.println("listening RetrieveContractorsEvent.");
    }
}
