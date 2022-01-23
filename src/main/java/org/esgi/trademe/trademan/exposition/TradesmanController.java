package org.esgi.trademe.trademan.exposition;

import org.esgi.trademe.trademan.application.create.CreateTradesman;
import org.esgi.trademe.trademan.application.create.education_level.AddTradesmanEducationLevel;
import org.esgi.trademe.trademan.application.create.experience.AddTradesmanExperience;
import org.esgi.trademe.trademan.application.retrieve.all.RetrieveTradesmen;
import org.esgi.trademe.trademan.application.retrieve.by_id.RetrieveTradesmanByID;
import org.esgi.trademe.trademan.application.retrieve.search.RetrieveTradesmanByEducation;
import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.trademan.domain.EducationLevel;
import org.esgi.trademe.trademan.domain.WorkDomain;
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

@SuppressWarnings("unused")
@RestController
public final class TradesmanController {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    public TradesmanController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus = queryBus;
        this.commandBus = commandBus;
    }

    @PostMapping(value="/tradesman", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradesmanDTO> register(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName,
                                                 @RequestParam(required = true) String email, @RequestParam(required = true) String birth,
                                                 @RequestParam(required = true) String username, @RequestParam(required = true) String password,
                                                 @RequestParam(required = true) String streetNumber, @RequestParam(required = true) String streetName,
                                                 @RequestParam(required = true) String zipCode, @RequestParam(required = true) String city,
                                                 @RequestParam(required = true) String country) throws InvalidEntryException, NoSuchAlgorithmException {

        final Tradesman tradesman = commandBus.send(CreateTradesman.of(firstName, lastName, email, TradesmanCredentialsDTO.of(username, password),
                AddressDTO.of(streetNumber, streetName, zipCode, city, country)));

        TradesmanDTO tradesmanDTOResponse = TradesmanDTO.of(tradesman);
        return ResponseEntity.ok(tradesmanDTOResponse);
    }

    @PutMapping(value = "/tradesman/education", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEducation(@RequestParam(required = true) String tradesman_id,
                                                       @RequestParam(required = true) String domain,
                                                       @RequestParam(required = true) String level) throws InvalidEntryException, NoSuchAlgorithmException {
        TradesmanID tradesmanID;
        WorkDomain workDomain;
        EducationLevel educationLevel;

        try {
            tradesmanID = TradesmanID.of(Integer.parseInt(tradesman_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(tradesman_id);
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

        commandBus.send(AddTradesmanEducationLevel.of(tradesmanID, workDomain, educationLevel));

        return ResponseEntity.ok(String.format("%s in %s domain added in tradesman %s education.", level, domain, tradesman_id.toString()));
    }

    @PutMapping(value = "/tradesman/experience", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addExperience(@RequestParam(required = true) String tradesman_id,
                                                       @RequestParam(required = true) String domain,
                                                       @RequestParam(required = true) String year) throws InvalidEntryException, NoSuchAlgorithmException {
        TradesmanID tradesmanID;
        WorkDomain workDomain;
        Integer yearExperience;

        try {
            tradesmanID = TradesmanID.of(Integer.parseInt(tradesman_id));
        } catch (NumberFormatException e) {
            throw InvalidParameterException.withStringInteger(tradesman_id);
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

        commandBus.send(AddTradesmanExperience.of(tradesmanID, workDomain, yearExperience));

        return ResponseEntity.ok(String.format("%s years experience in %s added to tradesman %s.", year, domain, tradesman_id.toString()));
    }

    @GetMapping(value = "/tradesmans/search", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradesmenDTO> getByEducationOrExperience(@RequestParam(required = true) List<String> domains) {
        List<WorkDomain> domainsTypes = new ArrayList<>();
        for(String domain: domains) {
            try {
                domainsTypes.add(WorkDomain.valueOf(domain));
            } catch (IllegalArgumentException | EnumConstantNotPresentException e) {
                throw InvalidChoiceException.withEnum(WorkDomain.class, domain);
            }
        }
        final TradesmenDTO tradesmansDTO = queryBus.send(new RetrieveTradesmanByEducation(domainsTypes));
        return ResponseEntity.ok(tradesmansDTO);
    }

    @GetMapping(value = "/tradesmans", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradesmenDTO> getAll() {
        final List<TradesmanDTO> tradesmen = queryBus.send(new RetrieveTradesmen());
        TradesmenDTO tradesmansDTOResult = new TradesmenDTO();
        tradesmansDTOResult.tradesmen = tradesmen;
        return ResponseEntity.ok(tradesmansDTOResult);
    }

    @GetMapping(value = "/tradesman", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradesmanDTO> getByID(@RequestParam(required = true) String id) {
        final TradesmanDTO tradesman = queryBus.send(new RetrieveTradesmanByID(TradesmanID.of(Integer.parseInt(id))));
        return ResponseEntity.ok(tradesman);
    }
    

}
