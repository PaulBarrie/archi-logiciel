package org.esgi.trademe.trademan.application.create;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class CreateTradesmanEvent implements ApplicationEvent {
    private final TradesmanID contractorID;

    public CreateTradesmanEvent(TradesmanID contractorID) {
        this.contractorID = contractorID;
    }

    public static CreateTradesmanEvent of(TradesmanID contractorID) {
        return new CreateTradesmanEvent(contractorID);
    }
}
