package org.esgi.trademe.project.application.update;



import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectStatus;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class AcceptProjectCommandHandler implements CommandHandler<AcceptProject, Project> {

    private final ProjectRepository contractRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public AcceptProjectCommandHandler(ProjectRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractRepository = contractRepository;
        this.eventDispatcher = eventEventDispatcher;
    }


    public static AcceptProjectCommandHandler of(ProjectRepository contractRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AcceptProjectCommandHandler(contractRepository,eventEventDispatcher);
    }

    public Project handle(AcceptProject createContractor) {
        Project contract = contractRepository.findById(createContractor.getContractID());
        contract.setContractStatus(ProjectStatus.ACCEPTED);
        contractRepository.add(contract);
        return contract;
    }
}
