package org.esgi.trademe.contract.application.create;


import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class CreateContractEvent implements ApplicationEvent {
    private final ContractID contractID;

    public CreateContractEvent(ContractID contractID) {
        this.contractID = contractID;
    }

    public static CreateContractEvent of(ContractID contractID) {
        return new CreateContractEvent(contractID);
    }
}
