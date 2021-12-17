package org.esgi.trademe.contractor.application.create.education_level;



import org.esgi.trademe.contractor.domain.*;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class AddContractorEducationLevelCommandHandler implements CommandHandler<AddContractorEducationLevel, Void> {

    private final ContractorRepository contractorRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    private AddContractorEducationLevelCommandHandler(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public static AddContractorEducationLevelCommandHandler of(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AddContractorEducationLevelCommandHandler(contractorRepository, eventEventDispatcher);
    }

    public Void handle(AddContractorEducationLevel addContractorEducationLevel) {
        contractorRepository.addEducation(addContractorEducationLevel.getContractorID(), addContractorEducationLevel.getWorkDomain(),
                addContractorEducationLevel.getEducationLevel());
        eventEventDispatcher.dispatch(new AddContractorEducationLevelEvent(addContractorEducationLevel.getContractorID()));
        return null;
    }
}
