package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectDTO;
import org.esgi.trademe.project.exposition.ProjectRepository;

import java.util.List;

public class RetrieveProjectByIDHandler implements QueryHandler<RetrieveProjectByID, ProjectDTO> {

    private final ProjectRepository projectRepository;
    private final ContractRepository contractRepository;

    public RetrieveProjectByIDHandler(ProjectRepository projectRepository, ContractRepository contractRepository) {
        this.projectRepository = projectRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public ProjectDTO handle(RetrieveProjectByID query) {
        Project project = projectRepository.findById(query.getId());
        List<Contract> contracts = contractRepository.findByProject(project.getProjectID());
        System.out.println(contracts);
        project.setContractList(contracts);
        return ProjectDTO.of(project);
    }


}
