package org.esgi.trademe.contract.exposition;

import org.esgi.trademe.contract.application.create.CreateContract;
import org.esgi.trademe.contract.application.retrieve.all.RetrieveContracts;
import org.esgi.trademe.contract.application.retrieve.by_id.RetrieveContractByID;
import org.esgi.trademe.contract.application.retrieve.by_tradesman.RetrieveContractByTradesman;
import org.esgi.trademe.contract.application.update.AcceptContract;
import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidChoiceException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.exceptions.InvalidParameterException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.tradesman.domain.WorkDomain;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@SuppressWarnings("unused")
@RestController
public final class ContractController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public ContractController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @PostMapping(value="/project/contract", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> addContract(@RequestParam(required = true) String project_id,
                                                @RequestParam(required = true) String hourly_wage,
                                                @RequestParam(required = true) String nb_hours,
                                                @RequestParam(required = true) String work_domain) throws InvalidEntryException, NoSuchAlgorithmException {

        ProjectID projectID;
        WorkDomain workDomain;
        Float hourlyWage;
        Integer nbHours;

        try {
            projectID = ProjectID.of(Integer.parseInt(project_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(project_id);
        }
        try {
            nbHours = Integer.parseInt(nb_hours);
        } catch (NumberFormatException e) {
            throw  InvalidParameterException.withStringInteger(nb_hours);
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
        Contract contract = commandBus.send(CreateContract.of(projectID, hourlyWage, nbHours, workDomain));

        return ResponseEntity.ok(ContractDTO.of(contract));

    }

    @PutMapping(value = "/contract/accept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> acceptProject(@RequestParam(required = true) String contract_id) throws InvalidEntryException, NoSuchAlgorithmException {
        ContractID contractID = toProjectID(contract_id);
        commandBus.send(AcceptContract.of(contractID));
        return ResponseEntity.ok(String.format("Project %s accepted by tradesman", contract_id));
    }

    @GetMapping(value = "/tradesman/contracts", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractsDTO> getByTradesman(@RequestParam(required = true) String tradesman_id) {
        TradesmanID tradesmanID = toTradesmanID(tradesman_id);
        final ContractsDTO contracts = queryBus.send(new RetrieveContractByTradesman(tradesmanID));
        return ResponseEntity.ok(contracts);
    }

    @GetMapping(value = "/contract", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> getByID(@RequestParam(required = true) String id) {
        ContractID contractID = toProjectID(id);
        final ContractDTO contract = queryBus.send(new RetrieveContractByID(contractID));
        return ResponseEntity.ok(contract);
    }

    @GetMapping(value = "/contracts", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractsDTO> getAll() {
        final ContractsDTO contracts = queryBus.send(new RetrieveContracts());
        return ResponseEntity.ok(contracts);
    }

    public static TradesmanID toTradesmanID(String id) {
        try {
            return TradesmanID.of(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(id);
        }
    }

    public static ContractID toProjectID(String id) {
        try {
            return ContractID.of(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(id);
        }
    }

}
