package org.esgi.trademe.contractor.application.update;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.contractor.domain.ContractorAddress;
import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.ContractorRepository;

public final class ModifyContractorAddressCommandHandler implements CommandHandler<ModifyContractorAddress, Void> {

    private final ContractorRepository contractorRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyContractorAddressCommandHandler(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(ModifyContractorAddress command) {
        ContractorID contractorId =  ContractorID.of(command.contractorId);
        Contractor contractor = contractorRepository.findById(contractorId);
        ContractorAddress address =  ContractorAddress.of(command.address.getStreetNumber(), command.address.getStreetNumber(),
                command.address.getZipCode(), command.address.getCity(), command.address.getCountry());
        contractor.changeAddress(address);
        contractorRepository.add(contractor);
        eventEventDispatcher.dispatch(new ModifyContractorAddressEvent(contractorId));
        return null;
    }
}
