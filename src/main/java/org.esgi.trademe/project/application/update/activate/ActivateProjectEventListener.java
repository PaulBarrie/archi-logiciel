package org.esgi.trademe.project.application.update.activate;


import org.esgi.trademe.kernel.event.EventListener;

public final class ActivateProjectEventListener implements EventListener<ActivateProjectEvent> {
    @Override
    public void listenTo(ActivateProjectEvent event) {
        System.out.println("listening ActivateProjectEvent.");
    }
}
