package org.esgi.trademe.project.application.create;



import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.project.domain.ProjectID;

public final class CreateProjectEvent implements ApplicationEvent {
    private final ProjectID projectID;

    public CreateProjectEvent(ProjectID projectID) {
        this.projectID = projectID;
    }

    public static CreateProjectEvent of(ProjectID projectID) {
        return new CreateProjectEvent(projectID);
    }
}
