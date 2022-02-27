package org.esgi.trademe.project.application.retrieve.all;

import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class RetrieveProjectsEvent implements ApplicationEvent {

    public RetrieveProjectsEvent(){
    }

    public static RetrieveProjectsEvent of() {
        return new RetrieveProjectsEvent();
    }
}
