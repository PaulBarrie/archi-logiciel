package org.esgi.trademe.contract.application.retrieve.by_project;

import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.project.domain.ProjectID;

public class RetrieveContractByProjectEvent implements ApplicationEvent {
    private final ProjectID projectID;

    public RetrieveContractByProjectEvent(ProjectID projectID) {
        this.projectID = projectID;
    }

    public static RetrieveContractByProjectEvent of(ProjectID projectID) {
        return new RetrieveContractByProjectEvent(projectID);
    }
}
