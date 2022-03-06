package org.esgi.trademe.project.application.update.assign_tradesmen;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.project.domain.ProjectID;


public final class AssignTradesmenToProjectEvent implements ApplicationEvent {
    private final ProjectID projectID;

    public AssignTradesmenToProjectEvent(ProjectID projectID) {
        this.projectID = projectID;
    }

    public static AssignTradesmenToProjectEvent of(ProjectID projectID) {
        return new AssignTradesmenToProjectEvent(projectID);
    }
}
