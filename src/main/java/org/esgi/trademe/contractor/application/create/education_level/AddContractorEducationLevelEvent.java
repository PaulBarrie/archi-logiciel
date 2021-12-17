package org.esgi.trademe.contractor.application.create.education_level;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class AddContractorEducationLevelEvent implements ApplicationEvent {
    private final ContractorID contractorID;

    public AddContractorEducationLevelEvent(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public static AddContractorEducationLevelEvent of(ContractorID contractorID) {
        return new AddContractorEducationLevelEvent(contractorID);
    }
}
