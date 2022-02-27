package org.esgi.trademe.contract.application.create;


import org.esgi.trademe.kernel.event.EventListener;

public final class CreateContractEventListener implements EventListener<CreateContractEvent> {
    @Override
    public void listenTo(CreateContractEvent event) {
        System.out.println("listening CreateContractEvent.");
    }
}
