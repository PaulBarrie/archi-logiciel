package org.esgi.trademe.project.exposition;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.project.application.create.CreateProject;
import org.esgi.trademe.project.application.retrieve.all.RetrieveProjects;
import org.esgi.trademe.project.application.retrieve.by_tradesman.RetrieveProjectByTradesman;
import org.esgi.trademe.project.application.retrieve.by_id.RetrieveProjectByID;
import org.esgi.trademe.project.application.update.AcceptProject;
import org.esgi.trademe.project.domain.Project;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.trademan.domain.EducationLevel;
import org.esgi.trademe.trademan.domain.WorkDomain;
import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidChoiceException;
import org.esgi.trademe.kernel.exceptions.InvalidParameterException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.contractor.domain.ContractorID;
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
    public ResponseEntity<ProjectDTO> register(@RequestParam(required = true) String contractor_id,
                                               @RequestParam(required = true) String tradesman_id,
                                               @RequestParam(required = true) String hourly_wage,
                                               @RequestParam(required = true) String hours_per_month,
                                               @RequestParam(required = true) String work_domain) throws InvalidEntryException, NoSuchAlgorithmException {

        ContractorID contractorID;
        TradesmanID tradesmanID = toTradesmanID(tradesman_id);
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
        Project contract = commandBus.send(CreateProject.of(contractorID, tradesmanID, hourlyWage, hoursPerMonth, workDomain));

        return ResponseEntity.ok(ProjectDTO.of(contract));

    }

    @PutMapping(value = "/project/accept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> acceptProject(@RequestParam(required = true) String project_id) throws InvalidEntryException, NoSuchAlgorithmException {
        ProjectID projectID = toProjectID(project_id);
        commandBus.send(AcceptProject.of(projectID));
        return ResponseEntity.ok(String.format("Project %s accepted by tradesman", project_id));
    }

    @GetMapping(value = "/tradesman/projects", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectsDTO> getByTradesman(@RequestParam(required = true) String tradesman_id) {
        TradesmanID tradesmanID = toTradesmanID(tradesman_id);
        final ProjectsDTO contracts = queryBus.send(new RetrieveProjectByTradesman(tradesmanID));
        return ResponseEntity.ok(contracts);
    }

    @GetMapping(value = "/project", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> getByID(@RequestParam(required = true) String id) {
        ProjectID contractID = toProjectID(id);
        final ProjectDTO contract = queryBus.send(new RetrieveProjectByID(contractID));
        return ResponseEntity.ok(contract);
    }

    @GetMapping(value = "/projects", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectsDTO> getAll() {
        final ProjectsDTO contracts = queryBus.send(new RetrieveProjects());
        return ResponseEntity.ok(contracts);
    }

    public static TradesmanID toTradesmanID(String id) {
        try {
            return TradesmanID.of(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(id);
        }
    }

    public static ProjectID toProjectID(String id) {
        try {
            return ProjectID.of(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(id);
        }
    }

}
