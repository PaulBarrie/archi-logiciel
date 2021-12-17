package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class RetrieveProjectByIDEvent implements ApplicationEvent {
    private final ProjectID projectID;

    public RetrieveProjectByIDEvent(ProjectID projectID) {
        this.projectID = projectID;
    }

    public static RetrieveProjectByIDEvent of(ProjectID projectID) {
        return new RetrieveProjectByIDEvent(projectID);
    }
}
