package org.esgi.trademe.project.application.update;



import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.domain.ContractStatus;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectStatus;
import org.esgi.trademe.project.exposition.ProjectRepository;

public final class ActivateProjectCommandHandler implements CommandHandler<ActivateProject, Project> {
    private final ProjectRepository projectRepository;
    private final ContractRepository contractRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public ActivateProjectCommandHandler(ProjectRepository projectRepository, ContractRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventEventDispatcher;
    }


    public static ActivateProjectCommandHandler of(ProjectRepository projectRepository,  ContractRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new ActivateProjectCommandHandler(projectRepository, contractRepository, eventEventDispatcher);
    }

    public Project handle(ActivateProject activateProject) {
        Project project = projectRepository.findById(activateProject.getProjectID());
        project.setContractStatus(ProjectStatus.ACCEPTED);
        for(Contract contract : project.getContractList()) {
            contract.setContractStatus(ContractStatus.PUBLISHED);
            contractRepository.add(contract);
        }
        projectRepository.add(project);
        return project;
    }
}
