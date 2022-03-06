package org.esgi.trademe.project.application.update.assign_tradesmen;


import org.esgi.trademe.kernel.event.EventListener;

public final class AssignTradesmenToProjectEventListener implements EventListener<AssignTradesmenToProjectEvent> {
    @Override
    public void listenTo(AssignTradesmenToProjectEvent event) {
        System.out.println("listening AssignTradesmenToProjectEvent.");
    }
}
