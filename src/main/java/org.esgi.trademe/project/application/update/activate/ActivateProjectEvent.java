package org.esgi.trademe.project.application.update.activate;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.project.domain.ProjectID;


public final class ActivateProjectEvent implements ApplicationEvent {
    private final ProjectID projectID;

    public ActivateProjectEvent(ProjectID projectID) {
        this.projectID = projectID;
    }

    public static ActivateProjectEvent of(ProjectID projectID) {
        return new ActivateProjectEvent(projectID);
    }
}
