package org.esgi.trademe.project.application.create;




import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.project.exposition.ProjectRepository;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class CreateProjectCommandHandler implements CommandHandler<CreateProject, Project> {

    private final ProjectRepository projectRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public CreateProjectCommandHandler(ProjectRepository projectRepository, EventDispatcher<Event> eventDispatcher) {
        this.projectRepository = projectRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public static CreateProjectCommandHandler of(ProjectRepository projectRepository, EventDispatcher<Event> eventDispatcher) {
        return new CreateProjectCommandHandler(projectRepository, eventDispatcher);
    }

    public Project handle(CreateProject createContract) {
        final ProjectID projectID = projectRepository.nextIdentity();
        Project project = Project.of(projectID, createContract.getContractorID(), createContract.getTradesmanID(),
                createContract.getHourlyWage(), createContract.getHoursPerMonth(), createContract.getWorkDomain());
        projectRepository.add(project);
        eventDispatcher.dispatch(new CreateProjectEvent(projectID));
        return project;
    }
}
