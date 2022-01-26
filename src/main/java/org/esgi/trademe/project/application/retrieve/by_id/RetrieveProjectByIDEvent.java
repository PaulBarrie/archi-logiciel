package org.esgi.trademe.project.application.retrieve.by_id;


import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class RetrieveProjectByIDEvent implements ApplicationEvent {
    private final ContractID contractID;

    public RetrieveProjectByIDEvent(ContractID contractID) {
        this.contractID = contractID;
    }

    public static RetrieveProjectByIDEvent of(ContractID contractID) {
        return new RetrieveProjectByIDEvent(contractID);
    }
}
