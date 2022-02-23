package org.esgi.trademe.project.exposition;

import org.esgi.trademe.project.domain.Project;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public final class ProjectsDTO {
    public List<Project> contracts = new ArrayList<>();

    private ProjectsDTO(List<Project> contracts) {
        this.contracts = contracts;
    }

    public static ProjectsDTO of(List<Project> contracts) {
        return new ProjectsDTO(contracts);
    }
}
