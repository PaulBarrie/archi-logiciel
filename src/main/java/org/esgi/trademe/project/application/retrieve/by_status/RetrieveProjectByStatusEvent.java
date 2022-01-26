package org.esgi.trademe.project.application.retrieve.by_status;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.project.domain.ProjectStatus;

public final class RetrieveProjectByStatusEvent implements ApplicationEvent {
    private final ProjectStatus contractStatus;

    public RetrieveProjectByStatusEvent(ProjectStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public static RetrieveProjectByStatusEvent of(ProjectStatus contractStatus) {
        return new RetrieveProjectByStatusEvent(contractStatus);
    }
}
