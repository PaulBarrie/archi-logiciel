package org.esgi.trademe.contractor.application.retrieve.all;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class RetrieveContractorsEvent implements ApplicationEvent {
    private final ContractorID contractorID;

    public RetrieveContractorsEvent(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public static RetrieveContractorsEvent of(ContractorID contractorID) {
        return new RetrieveContractorsEvent(contractorID);
    }
}
