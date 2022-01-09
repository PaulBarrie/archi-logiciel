package org.esgi.trademe.contractor.application.create.experience;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class AddContractorExperienceEvent implements ApplicationEvent {
    private final ContractorID memberID;

    public AddContractorExperienceEvent(ContractorID memberID) {
        this.memberID = memberID;
    }

    public static AddContractorExperienceEvent of(ContractorID memberID) {
        return new AddContractorExperienceEvent(memberID);
    }
}
