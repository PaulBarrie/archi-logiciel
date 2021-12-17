package org.esgi.trademe.project.application.retrieve.by_status;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;

import java.util.List;

public class RetrieveProjectByStatusHandler implements QueryHandler<RetrieveProjectByStatus, ProjectsDTO> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectByStatusHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjectByStatus query) {
        List<Project> projects = projectRepository.findByStatus(query.getStatus());
        return ProjectsDTO.of(projects);
    }
}
