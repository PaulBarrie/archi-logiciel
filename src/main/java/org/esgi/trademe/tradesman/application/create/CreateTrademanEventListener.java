package org.esgi.trademe.tradesman.application.create;


import org.esgi.trademe.contract.application.create.CreateContractEvent;
import org.esgi.trademe.kernel.event.EventListener;

public final class CreateTrademanEventListener implements EventListener<CreateContractEvent> {
    @Override
    public void listenTo(CreateContractEvent event) {
        System.out.println("listening CreateContractEvent.");
    }
}
