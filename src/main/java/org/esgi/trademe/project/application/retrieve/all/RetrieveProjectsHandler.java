package org.esgi.trademe.project.application.retrieve.all;


import org.esgi.trademe.project.exposition.ProjectDTO;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.stream.Collectors;

public class RetrieveProjectsHandler implements QueryHandler<RetrieveProjects, ProjectsDTO> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectsHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjects query) {
        return ProjectsDTO.of(projectRepository.findAll());
    }
}
