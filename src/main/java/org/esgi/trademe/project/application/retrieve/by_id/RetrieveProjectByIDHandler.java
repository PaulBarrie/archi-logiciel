package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectDTO;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.kernel.query.QueryHandler;

public class RetrieveProjectByIDHandler implements QueryHandler<RetrieveProjectByID, ProjectDTO> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectByIDHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDTO handle(RetrieveProjectByID query) {
        Project project = projectRepository.findById(query.getId());
        return ProjectDTO.of(project);
    }
}
