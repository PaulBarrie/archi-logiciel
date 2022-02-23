package org.esgi.trademe.contractor.application.retrieve.by_id;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.contractor.domain.ContractorID;

public final class RetrieveContractorByIDEvent implements ApplicationEvent {
    private final ContractorID contractorID;

    public RetrieveContractorByIDEvent(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public static RetrieveContractorByIDEvent of(ContractorID contractorID) {
        return new RetrieveContractorByIDEvent(contractorID);
    }
}
