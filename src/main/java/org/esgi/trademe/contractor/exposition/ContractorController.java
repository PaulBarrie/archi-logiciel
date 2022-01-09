package org.esgi.trademe.contractor.exposition;

import org.esgi.trademe.contractor.application.create.CreateContractor;
import org.esgi.trademe.contractor.application.create.education_level.AddContractorEducationLevel;
import org.esgi.trademe.contractor.application.create.experience.AddContractorExperience;
import org.esgi.trademe.contractor.application.retrieve.all.RetrieveContractors;
import org.esgi.trademe.contractor.application.retrieve.by_id.RetrieveContractorByID;
import org.esgi.trademe.contractor.application.retrieve.search.RetrieveContractorByEducation;
import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.EducationLevel;
import org.esgi.trademe.contractor.domain.WorkDomain;
import org.esgi.trademe.kernel.exceptions.InvalidChoiceException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.exceptions.InvalidParameterException;
import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.query.QueryBus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@RestController
public final class ContractorController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public ContractorController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @PostMapping(value="/contractor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractorDTO> register(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName,
                                                  @RequestParam(required = true) String email, @RequestParam(required = true) String birth,
                                                  @RequestParam(required = true) String username, @RequestParam(required = true) String password,
                                                  @RequestParam(required = true) String streetNumber, @RequestParam(required = true) String streetName,
                                                  @RequestParam(required = true) String zipCode, @RequestParam(required = true) String city,
                                                  @RequestParam(required = true) String country) throws InvalidEntryException, NoSuchAlgorithmException {

        final Contractor contractor = commandBus.send(CreateContractor.of(firstName, lastName, email, ContractorCredentialsDTO.of(username, password),
                AddressDTO.of(streetNumber, streetName, zipCode, city, country)));

        ContractorDTO contractorDTOResponse = ContractorDTO.of(contractor);
        return ResponseEntity.ok(contractorDTOResponse);
    }

    @PutMapping(value = "/contractor/education", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEducation(@RequestParam(required = true) String contractor_id,
                                                       @RequestParam(required = true) String domain,
                                                       @RequestParam(required = true) String level) throws InvalidEntryException, NoSuchAlgorithmException {
        ContractorID contractorID;
        WorkDomain workDomain;
        EducationLevel educationLevel;

        try {
            contractorID = ContractorID.of(Integer.parseInt(contractor_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(contractor_id);
        }
        try {
            workDomain = WorkDomain.valueOf(domain);
        } catch (EnumConstantNotPresentException | IllegalArgumentException e) {
            throw  InvalidChoiceException.withEnum(WorkDomain.class, domain);
        }
        try {
            educationLevel = EducationLevel.valueOf(level);
        } catch (EnumConstantNotPresentException e) {
            throw  InvalidChoiceException.withEnum(EducationLevel.class, level);
        }

        commandBus.send(AddContractorEducationLevel.of(contractorID, workDomain, educationLevel));

        return ResponseEntity.ok(String.format("%s in %s domain added in contractor %s education.", level, domain, contractor_id.toString()));
    }

    @PutMapping(value = "/contractor/experience", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addExperience(@RequestParam(required = true) String contractor_id,
                                                       @RequestParam(required = true) String domain,
                                                       @RequestParam(required = true) String year) throws InvalidEntryException, NoSuchAlgorithmException {
        ContractorID contractorID;
        WorkDomain workDomain;
        Integer yearExperience;

        try {
            contractorID = ContractorID.of(Integer.parseInt(contractor_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(contractor_id);
        }
        try {
            workDomain = WorkDomain.valueOf(domain);
        } catch (EnumConstantNotPresentException e) {
            throw InvalidChoiceException.withEnum(WorkDomain.class, domain);
        }
        try {
            yearExperience = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(year);
        }

        commandBus.send(AddContractorExperience.of(contractorID, workDomain, yearExperience));

        return ResponseEntity.ok(String.format("%s years experience in %s added to contractor %s.", year, domain, contractor_id.toString()));
    }

    @GetMapping(value = "/contractors/search", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractorsDTO> getByEducationOrExperience(@RequestParam(required = true) List<String> domains) {
        List<WorkDomain> domainsTypes = new ArrayList<>();
        for(String domain: domains) {
            try {
                domainsTypes.add(WorkDomain.valueOf(domain));
            } catch (IllegalArgumentException | EnumConstantNotPresentException e) {
                throw InvalidChoiceException.withEnum(WorkDomain.class, domain);
            }
        }
        final ContractorsDTO contractorsDTO = queryBus.send(new RetrieveContractorByEducation(domainsTypes));
        return ResponseEntity.ok(contractorsDTO);
    }

    @GetMapping(value = "/contractors", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractorsDTO> getAll() {
        final List<ContractorDTO> contractors = queryBus.send(new RetrieveContractors());
        ContractorsDTO contractorsDTOResult = new ContractorsDTO();
        contractorsDTOResult.contractors = contractors;
        return ResponseEntity.ok(contractorsDTOResult);
    }

    @GetMapping(value = "/contractor", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractorDTO> getByID(@RequestParam(required = true) String id) {
        final ContractorDTO contractor = queryBus.send(new RetrieveContractorByID(ContractorID.of(Integer.parseInt(id))));
        return ResponseEntity.ok(contractor);
    }
    

}
