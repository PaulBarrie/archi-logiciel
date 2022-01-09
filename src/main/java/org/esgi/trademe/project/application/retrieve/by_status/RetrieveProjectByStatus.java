package org.esgi.trademe.project.application.retrieve.by_status;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.project.domain.ProjectStatus;

public final class RetrieveProjectByStatus implements Query {
    private final ProjectStatus status;

    public RetrieveProjectByStatus(ProjectStatus status) {
        this.status = status;
    }

    public ProjectStatus getStatus() {
        return status;
    }
}
