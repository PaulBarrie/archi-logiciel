package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.kernel.query.Query;

public class RetrieveProjectByID implements Query {
    private final ProjectID id;

    public RetrieveProjectByID(ProjectID id) {
        this.id = id;
    }

    public ProjectID getId() {
        return id;
    }
}
