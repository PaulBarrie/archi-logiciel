package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.project.application.create.CreateProjectEvent;
import org.esgi.trademe.kernel.event.EventListener;

public final class CreateContractorEventListener implements EventListener<CreateProjectEvent> {
    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening CreateContractEvent.");
    }
}
