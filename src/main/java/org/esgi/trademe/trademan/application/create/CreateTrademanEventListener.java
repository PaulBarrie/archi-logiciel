package org.esgi.trademe.trademan.application.create;


import org.esgi.trademe.project.application.create.CreateProjectEvent;
import org.esgi.trademe.kernel.event.EventListener;

public final class CreateTrademanEventListener implements EventListener<CreateProjectEvent> {
    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening CreateContractEvent.");
    }
}
