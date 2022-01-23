package org.esgi.trademe.contractor.application.update;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.contractor.domain.ContractorID;

public final class ModifyContractorAddressEvent implements ApplicationEvent {
    private final ContractorID contractorId;

    public ModifyContractorAddressEvent(ContractorID contractorId) {
        this.contractorId = contractorId;
    }
}
