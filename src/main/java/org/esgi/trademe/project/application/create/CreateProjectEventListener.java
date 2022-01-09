package org.esgi.trademe.project.application.create;


import org.esgi.trademe.kernel.event.EventListener;

public final class CreateProjectEventListener implements EventListener<CreateProjectEvent> {
    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening CreateProjectEvent.");
    }
}
