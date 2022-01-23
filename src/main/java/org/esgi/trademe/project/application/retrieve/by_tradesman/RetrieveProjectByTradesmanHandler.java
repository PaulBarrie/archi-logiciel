package org.esgi.trademe.project.application.retrieve.by_tradesman;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;

import java.util.List;

public class RetrieveProjectByTradesmanHandler implements QueryHandler<RetrieveProjectByTradesman, ProjectsDTO> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectByTradesmanHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjectByTradesman query) {
        List<Project> projects = projectRepository.findByTradesman(query.getTradesmanID());
        return ProjectsDTO.of(projects);
    }
}
