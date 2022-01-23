package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.contractor.domain.ContractorID;

public final class CreateContractorEvent implements ApplicationEvent {
    private final ContractorID contractorID;

    public CreateContractorEvent(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public static CreateContractorEvent of(ContractorID contractorID) {
        return new CreateContractorEvent(contractorID);
    }
}
