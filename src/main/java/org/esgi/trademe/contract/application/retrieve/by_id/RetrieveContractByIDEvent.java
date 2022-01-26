package org.esgi.trademe.contract.application.retrieve.by_id;


import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class RetrieveContractByIDEvent implements ApplicationEvent {
    private final ContractID contractID;

    public RetrieveContractByIDEvent(ContractID contractID) {
        this.contractID = contractID;
    }

    public static RetrieveContractByIDEvent of(ContractID contractID) {
        return new RetrieveContractByIDEvent(contractID);
    }
}
