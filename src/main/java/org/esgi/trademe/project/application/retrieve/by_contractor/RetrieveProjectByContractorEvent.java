package org.esgi.trademe.project.application.retrieve.by_contractor;

import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class RetrieveProjectByContractorEvent implements ApplicationEvent {
    private final ContractorID contractorID;

    public RetrieveProjectByContractorEvent(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public static RetrieveProjectByContractorEvent of(ContractorID contractorID) {
        return new RetrieveProjectByContractorEvent(contractorID);
    }
}
