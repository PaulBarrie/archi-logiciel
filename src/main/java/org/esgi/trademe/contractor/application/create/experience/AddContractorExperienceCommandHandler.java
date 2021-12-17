package org.esgi.trademe.contractor.application.create.experience;



import org.esgi.trademe.contractor.domain.*;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class AddContractorExperienceCommandHandler implements CommandHandler<AddContractorExperience, Void> {

    private final ContractorRepository contractorRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    private AddContractorExperienceCommandHandler(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public static AddContractorExperienceCommandHandler of(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AddContractorExperienceCommandHandler(contractorRepository, eventEventDispatcher);
    }

    public Void handle(AddContractorExperience addContractorExperience) {
        contractorRepository.addExperience(addContractorExperience.getContractorID(), addContractorExperience.getWorkDomain(),
                addContractorExperience.getExperienceYear());
        eventEventDispatcher.dispatch(new AddContractorExperienceEvent(addContractorExperience.getContractorID()));
        return null;
    }
}
