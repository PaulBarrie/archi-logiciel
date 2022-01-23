package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.contractor.domain.*;
import org.esgi.trademe.contractor.validation.credentials.ContractorCredentialsDataHandler;
import org.esgi.trademe.contractor.validation.credentials.UsernameUnicityHandler;
import org.esgi.trademe.contractor.validation.contractor.ContractorDataHandler;
import org.esgi.trademe.contractor.validation.ContractorHandler;
import org.esgi.trademe.contractor.validation.contractor.ContractorUnicityHandler;


import java.security.NoSuchAlgorithmException;

public final class CreateContractorCommandHandler implements CommandHandler<CreateContractor, Contractor> {
    private final ContractorRepository contractorRepository;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final ContractorHandler handler;

    private CreateContractorCommandHandler(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.eventEventDispatcher = eventEventDispatcher;
        this.handler  = new ContractorDataHandler();
        handler.setNext(new ContractorUnicityHandler(contractorRepository))
                .setNext(new ContractorCredentialsDataHandler())
                .setNext(new UsernameUnicityHandler(contractorRepository));

    }

    public static CreateContractorCommandHandler of(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new CreateContractorCommandHandler(contractorRepository, eventEventDispatcher);
    }

    public Contractor handle(CreateContractor createContractor) throws NoSuchAlgorithmException, InvalidEntryException {
        final ContractorID contractorID = contractorRepository.nextIdentity();
        Contractor contractor =  Contractor.of(contractorID, createContractor.firstname, createContractor.lastname, createContractor.email, createContractor.birth,
                ContractorCredentials.of(createContractor.credentials.getUsername(), createContractor.credentials.getPassword()),
                ContractorAddress.of(createContractor.address.getStreetNumber(), createContractor.address.getStreetName(), createContractor.address.getZipCode(),
                        createContractor.address.getCity(), createContractor.address.getCountry()));
        handler.check(contractor);
        contractorRepository.add(contractor);
        eventEventDispatcher.dispatch(new CreateContractorEvent(contractorID));
        return contractor;
    }
}
