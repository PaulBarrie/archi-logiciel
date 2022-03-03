package org.esgi.trademe.contractor.exposition;

import org.esgi.trademe.kernel.command.CommandBus;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.query.QueryBus;
import org.esgi.trademe.contractor.application.create.CreateContractor;
import org.esgi.trademe.contractor.application.retrieve.by_id.RetrieveContractorByID;
import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.esgi.trademe.contractor.application.retrieve.all.RetrieveContractors;

import java.security.NoSuchAlgorithmException;
import java.util.List;

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
    public ResponseEntity<ContractorDTO> register(@RequestParam(required = true, name = "first_name" ) String first_name,
                                                  @RequestParam(required = true, name = "last_name") String last_name,
                                                  @RequestParam(required = true, name= "email") String email,
                                                  @RequestParam(required = true, name= "birth") String birth,
                                                  @RequestParam(required = true, name= "username") String username,
                                                  @RequestParam(required = true, name= "password") String password,
                                                  @RequestParam(required = true, name= "street_number") String street_number,
                                                  @RequestParam(required = true, name= "street_name") String street_name,
                                                  @RequestParam(required = true, name= "zip_code") String zip_code,
                                                  @RequestParam(required = true, name= "city") String city,
                                                  @RequestParam(required = true, name= "country") String country)
            throws InvalidEntryException, NoSuchAlgorithmException {

        final Contractor contractor = commandBus.send(CreateContractor.of(first_name, last_name, email, birth, ContractorCredentialsDTO.of(username, password),
                ContractorAddressDTO.of(street_number, street_name, zip_code, city, country)));
        ContractorDTO contractorDTOResponse = ContractorDTO.of(contractor);

        return ResponseEntity.ok(contractorDTOResponse);
    }

    @GetMapping(value = "/contractor", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractorDTO> get(@RequestParam(required = true) String id) {
        final ContractorDTO contractorsDTOResult = queryBus.send(new RetrieveContractorByID(ContractorID.of(Integer.parseInt(id))));
        return ResponseEntity.ok(contractorsDTOResult);
    }

    @GetMapping(value = "/contractors", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractorsDTO> getAll() {
        final List<ContractorDTO> contractors = queryBus.send(new RetrieveContractors());
        ContractorsDTO contractorsDTOResult = new ContractorsDTO();
        contractorsDTOResult.contractors = contractors;
        return ResponseEntity.ok(contractorsDTOResult);
    }
    

}
