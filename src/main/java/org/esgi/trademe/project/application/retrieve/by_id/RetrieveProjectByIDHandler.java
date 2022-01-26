package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectDTO;
import org.esgi.trademe.project.exposition.ProjectRepository;

public class RetrieveProjectByIDHandler implements QueryHandler<RetrieveProjectByID, ProjectDTO> {

    private final ProjectRepository contractRepository;

    public RetrieveProjectByIDHandler(ProjectRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ProjectDTO handle(RetrieveProjectByID query) {
        Project contract = contractRepository.findById(query.getId());
        return ProjectDTO.of(contract);
    }
}
