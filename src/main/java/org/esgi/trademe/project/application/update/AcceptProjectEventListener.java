package org.esgi.trademe.project.application.update;


import org.esgi.trademe.kernel.event.EventListener;

public class AcceptProjectEventListener implements EventListener<AcceptProjectEvent> {
    @Override
    public void listenTo(AcceptProjectEvent event) {
        System.out.println("listening CreateMemberEvent.");
    }
}