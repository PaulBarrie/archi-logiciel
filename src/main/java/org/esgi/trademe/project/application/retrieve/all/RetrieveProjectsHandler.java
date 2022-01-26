package org.esgi.trademe.project.application.retrieve.all;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;


public final class RetrieveProjectsHandler implements QueryHandler<RetrieveProjects, ProjectsDTO> {

    private final ProjectRepository contractRepository;

    public RetrieveProjectsHandler(ProjectRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjects query) {
        return ProjectsDTO.of(contractRepository.findAll());
    }
}
