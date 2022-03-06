package org.esgi.trademe.project.exposition;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.exceptions.InvalidParameterException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.project.application.create.CreateProject;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjects;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractor;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByID;
import org.esgi.trademe.project.application.update.activate.ActivateProject;
import org.esgi.trademe.project.application.update.assign_tradesmen.AssignTradesmenToProject;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@SuppressWarnings("unused")
@RestController
public final class ProjectController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public ProjectController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @PostMapping(value="/project", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> create(@RequestParam(required = true) String contractor_id,
                                               @RequestParam(required = true) String day_duration,
                                               @RequestParam(required = true) String location) throws InvalidEntryException, NoSuchAlgorithmException {

        ContractorID contractorID;
        Integer dayDuration;


        try {
            contractorID = ContractorID.of(Integer.parseInt(contractor_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(contractor_id);
        }
        try {
            dayDuration = Integer.parseInt(day_duration);
        } catch (NumberFormatException e) {
            throw  InvalidParameterException.withStringInteger(day_duration);
        }

        Project project = commandBus.send(CreateProject.of(contractorID, dayDuration, location));

        return ResponseEntity.ok(ProjectDTO.of(project));

    }

    @PutMapping(value = "/project/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> acceptProject(@RequestParam(required = true) String project_id) throws InvalidEntryException, NoSuchAlgorithmException {
        commandBus.send(ActivateProject.of(ProjectID.of(Integer.parseInt(project_id))));
        return ResponseEntity.ok(String.format("Project %s activated by tradesman", project_id));
    }

    @PutMapping(value = "/project/tradesmen/match", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> matchTradesman(@RequestParam(required = true) String project_id) throws InvalidEntryException, NoSuchAlgorithmException {
        ProjectDTO project = commandBus.send(AssignTradesmenToProject.of(ProjectID.of(Integer.parseInt(project_id))));
        return ResponseEntity.ok(project);
    }
    
    @GetMapping(value = "/contractor/projects", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectsDTO> getByContractor(@RequestParam(required = true) String contractor_id) {
        Contractor contractor = queryBus.send(RetrieveProjectByContractor.of(ContractorID.of(Integer.parseInt(contractor_id))));
        final ProjectsDTO projects = queryBus.send(RetrieveProjectByContractor.of(contractor.getId()));
        return ResponseEntity.ok(projects);
    }

    @GetMapping(value = "/project", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> getByID(@RequestParam(required = true) String id) {
        ProjectDTO project = queryBus.send(RetrieveProjectByID.of(ProjectID.of(Integer.parseInt(id))));
        return ResponseEntity.ok(project);
    }

    @GetMapping(value = "/projects", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectsDTO> getAll() {
        final ProjectsDTO projects = queryBus.send(new RetrieveProjects());
        return ResponseEntity.ok(projects);
    }
}
