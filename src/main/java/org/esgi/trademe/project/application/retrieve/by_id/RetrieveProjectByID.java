package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.project.domain.ProjectID;


public class RetrieveProjectByID implements Query {
    private final ProjectID projectID;

    private RetrieveProjectByID(ProjectID projectID) {
        this.projectID = projectID;
    }
    
    public static RetrieveProjectByID of(ProjectID projectID) {
        return new RetrieveProjectByID(projectID);
    }

    public ProjectID getId() {
        return projectID;
    }
}
