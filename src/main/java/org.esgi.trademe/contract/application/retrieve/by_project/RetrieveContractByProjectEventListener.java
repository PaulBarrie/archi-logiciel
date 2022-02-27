package org.esgi.trademe.contract.application.retrieve.by_project;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveContractByProjectEventListener implements EventListener<RetrieveContractByProjectEvent> {
    @Override
    public void listenTo(RetrieveContractByProjectEvent event) {
        System.out.println("listening RetrieveContractByProjectEvent.");
    }
}
