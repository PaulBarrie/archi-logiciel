package org.esgi.trademe.project.application.retrieve.by_status;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.project.domain.ProjectStatus;

public class RetrieveProjectByStatusEvent implements ApplicationEvent {
    private final ProjectStatus projectStatus;

    public RetrieveProjectByStatusEvent(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public static RetrieveProjectByStatusEvent of(ProjectStatus projectStatus) {
        return new RetrieveProjectByStatusEvent(projectStatus);
    }
}
