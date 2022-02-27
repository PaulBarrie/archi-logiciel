package org.esgi.trademe.contract.application.retrieve.by_status;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.contract.domain.ContractStatus;

public final class RetrieveContractByStatusEvent implements ApplicationEvent {
    private final ContractStatus contractStatus;

    public RetrieveContractByStatusEvent(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public static RetrieveContractByStatusEvent of(ContractStatus contractStatus) {
        return new RetrieveContractByStatusEvent(contractStatus);
    }
}
