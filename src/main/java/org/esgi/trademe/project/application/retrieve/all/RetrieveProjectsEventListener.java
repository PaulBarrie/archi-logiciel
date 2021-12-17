package org.esgi.trademe.project.application.retrieve.all;


import org.esgi.trademe.kernel.event.EventListener;

public class RetrieveProjectsEventListener implements EventListener<RetrieveProjectsEvent> {
    @Override
    public void listenTo(RetrieveProjectsEvent event) {
        System.out.println("listening RetrieveProjectsEvent.");
    }
}
