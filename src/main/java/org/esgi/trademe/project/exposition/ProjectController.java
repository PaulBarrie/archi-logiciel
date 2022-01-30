package org.esgi.trademe.project.exposition;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidChoiceException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.exceptions.InvalidParameterException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.project.application.create.CreateProject;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjects;
import org.esgi.trademe.project.application.retrieve.by_contractor.RetrieveProjectByContractor;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByID;
import org.esgi.trademe.project.application.update.ActivateProject;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.tradesman.domain.EducationLevel;
import org.esgi.trademe.tradesman.domain.WorkDomain;
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
                                               @RequestParam(required = true) String tradesman_id,
                                               @RequestParam(required = true) String hourly_wage,
                                               @RequestParam(required = true) String hours_per_month,
                                               @RequestParam(required = true) String work_domain) throws InvalidEntryException, NoSuchAlgorithmException {

        ContractorID contractorID;
        WorkDomain workDomain;
        EducationLevel educationLevel;
        Float hourlyWage;
        Integer hoursPerMonth;

        try {
            contractorID = ContractorID.of(Integer.parseInt(contractor_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(contractor_id);
        }
        try {
            hoursPerMonth = Integer.parseInt(hours_per_month);
        } catch (NumberFormatException e) {
            throw  InvalidParameterException.withStringInteger(hours_per_month);
        }
        try {
            hourlyWage = Float.valueOf(hourly_wage);
        } catch (NumberFormatException e) {
            throw  InvalidParameterException.withStringInteger(hourly_wage);
        }
        try {
            workDomain = WorkDomain.valueOf(work_domain);
        } catch (EnumConstantNotPresentException | IllegalArgumentException e) {
            throw InvalidChoiceException.withEnum(WorkDomain.class, work_domain);
        }
        Project project = commandBus.send(CreateProject.of(contractorID, hourlyWage, hoursPerMonth, workDomain));

        return ResponseEntity.ok(ProjectDTO.of(project));

    }

    @PutMapping(value = "/project/accept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> acceptProject(@RequestParam(required = true) String project_id) throws InvalidEntryException, NoSuchAlgorithmException {
        Project project = queryBus.send(RetrieveProjectByContractor.of(ContractorID.of(Integer.parseInt(project_id))));
        commandBus.send(ActivateProject.of(ProjectID.of(Integer.parseInt(project_id))));
        return ResponseEntity.ok(String.format("Project %s accepted by tradesman", project_id));
    }

    @GetMapping(value = "/contractor/projects", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectsDTO> getByContractor(@RequestParam(required = true) String contractor_id) {
        Contractor contractor = queryBus.send(RetrieveProjectByContractor.of(ContractorID.of(Integer.parseInt(contractor_id))));
        final ProjectsDTO projects = queryBus.send(RetrieveProjectByContractor.of(contractor.getId()));
        return ResponseEntity.ok(projects);
    }

    @GetMapping(value = "/project", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> getByID(@RequestParam(required = true) String id) {
        Project project = queryBus.send(RetrieveProjectByID.of(ProjectID.of(Integer.parseInt(id))));
        return ResponseEntity.ok(ProjectDTO.of(project));
    }

    @GetMapping(value = "/projects", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectsDTO> getAll() {
        final ProjectsDTO projects = queryBus.send(new RetrieveProjects());
        return ResponseEntity.ok(projects);
    }


}
