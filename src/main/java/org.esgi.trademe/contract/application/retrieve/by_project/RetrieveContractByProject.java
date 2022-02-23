package org.esgi.trademe.contract.application.retrieve.by_project;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.project.domain.ProjectID;

public class RetrieveContractByProject implements Query {
    private final ProjectID projectID;

    public RetrieveContractByProject(ProjectID projectID) {
        this.projectID = projectID;
    }

    public ProjectID getProjectID() {
        return projectID;
    }
}
