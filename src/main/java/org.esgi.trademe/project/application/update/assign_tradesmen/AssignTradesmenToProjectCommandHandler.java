package org.esgi.trademe.project.application.update.assign_tradesmen;


import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.exposition.ProjectDTO;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.project.infrastructure.engine.SimpleMatchCriterions;
import org.esgi.trademe.project.infrastructure.engine.SimpleTradesmanSearchEngine;
import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.tradesman.domain.TradesmanRepository;
import org.esgi.trademe.tradesman.domain.WorkDomain;

import java.util.List;

public final class AssignTradesmenToProjectCommandHandler implements CommandHandler<AssignTradesmenToProject, ProjectDTO> {
    private final ProjectRepository projectRepository;
    private final ContractRepository contractRepository;
    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public AssignTradesmenToProjectCommandHandler(ProjectRepository projectRepository, ContractRepository contractRepository, TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.projectRepository = projectRepository;
        this.contractRepository = contractRepository;
        this.tradesmanRepository = tradesmanRepository;
        this.eventDispatcher = eventEventDispatcher;
    }


    public static AssignTradesmenToProjectCommandHandler of(ProjectRepository projectRepository, ContractRepository contractRepository, TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AssignTradesmenToProjectCommandHandler(projectRepository, contractRepository, tradesmanRepository, eventEventDispatcher);
    }

    public ProjectDTO handle(AssignTradesmenToProject activateProject) {
        Project project = projectRepository.findById(activateProject.getProjectID());
        List<Contract> contracts = contractRepository.findByProject(project.getProjectID());
        for (Contract contract : contracts) {
            List<Tradesman> tradesmen = tradesmanRepository.findByEducationOrExperience(List.of(contract.getWorkDomain()));
            contract.setTradesmanID(SimpleTradesmanSearchEngine.of(tradesmen).search(SimpleMatchCriterions.of()).getId());
            contractRepository.add(contract);
        }
        eventDispatcher.dispatch(new AssignTradesmenToProjectEvent(project.getProjectID()));
        return ProjectDTO.of(project);
    }
}
