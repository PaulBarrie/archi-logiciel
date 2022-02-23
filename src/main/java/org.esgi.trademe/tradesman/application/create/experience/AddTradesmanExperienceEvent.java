package org.esgi.trademe.tradesman.application.create.experience;


import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class AddTradesmanExperienceEvent implements ApplicationEvent {
    private final TradesmanID contractorID;

    public AddTradesmanExperienceEvent(TradesmanID contractorID) {
        this.contractorID = contractorID;
    }

    public static AddTradesmanExperienceEvent of(TradesmanID contractorID) {
        return new AddTradesmanExperienceEvent(contractorID);
    }
}
