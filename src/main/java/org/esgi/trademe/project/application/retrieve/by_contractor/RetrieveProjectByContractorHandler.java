package org.esgi.trademe.project.application.retrieve.by_contractor;


import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractor;
import org.esgi.trademe.project.domain.Project;

import org.esgi.trademe.project.exposition.ProjectDTO;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.exposition.ProjectsDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveProjectByContractorHandler implements QueryHandler<RetrieveProjectByContractor, ProjectsDTO> {

    private final ProjectRepository projectRepository;

    public RetrieveProjectByContractorHandler(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectsDTO handle(RetrieveProjectByContractor query) {
        List<Project> projects = projectRepository.findByContractor(query.getContractorID());
        return ProjectsDTO.of(projects);
    }
}
