package org.esgi.trademe.project.application.retrieve.by_contractor;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;

import java.util.List;

public class RetrieveProjectByTradesmanHandler implements QueryHandler<RetrieveProjectByTradesman, ProjectsDTO> {

    private final ProjectRepository contractRepository;

    public RetrieveProjectByTradesmanHandler(ProjectRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjectByTradesman query) {
        List<Project> contracts = contractRepository.findByTradesman(query.getTradesmanID());
        return ProjectsDTO.of(contracts);
    }
}
