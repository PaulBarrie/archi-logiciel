package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class CreateContractorEvent implements ApplicationEvent {
    private final ContractorID memberID;

    public CreateContractorEvent(ContractorID memberID) {
        this.memberID = memberID;
    }

    public static CreateContractorEvent of(ContractorID memberID) {
        return new CreateContractorEvent(memberID);
    }
}
