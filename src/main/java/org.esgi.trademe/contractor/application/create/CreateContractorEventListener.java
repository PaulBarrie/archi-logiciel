package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.kernel.event.EventListener;

public final class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    @Override
    public void listenTo(CreateContractorEvent event) {
        System.out.println("listening CreateContractorEvent.");
    }
}
