package org.esgi.trademe.project.application.retrieve.by_status;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;

import java.util.List;

public final class RetrieveProjectByStatusHandler implements QueryHandler<RetrieveProjectByStatus, ProjectsDTO> {

    private final ProjectRepository contractRepository;

    public RetrieveProjectByStatusHandler(ProjectRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjectByStatus query) {
        List<Project> contracts = contractRepository.findByStatus(query.getStatus());
        return ProjectsDTO.of(contracts);
    }
}
