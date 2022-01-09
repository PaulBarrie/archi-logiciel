package org.esgi.trademe.project.exposition;

import org.esgi.trademe.project.domain.Project;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public final class ProjectsDTO {
    public List<Project> projects = new ArrayList<>();

    private ProjectsDTO(List<Project> projects) {
        this.projects = projects;
    }

    public static ProjectsDTO of(List<Project> projects) {
        return new ProjectsDTO(projects);
    }
}
