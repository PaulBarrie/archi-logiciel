package org.esgi.trademe.project.application.update;



import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectStatus;
import org.esgi.trademe.project.exposition.ProjectRepository;

public final class ActivateProjectCommandHandler implements CommandHandler<ActivateProject, Project> {

    private final ProjectRepository contractRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public ActivateProjectCommandHandler(ProjectRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventEventDispatcher;
    }


    public static ActivateProjectCommandHandler of(ProjectRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new ActivateProjectCommandHandler(contractRepository,eventEventDispatcher);
    }

    public Project handle(ActivateProject createTradesman) {
        Project contract = contractRepository.findById(createTradesman.getContractID());
        contract.setContractStatus(ProjectStatus.ACCEPTED);
        contractRepository.add(contract);
        return contract;
    }
}
