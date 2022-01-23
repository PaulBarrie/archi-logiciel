package org.esgi.trademe.project.application.update;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class AcceptProjectEvent implements ApplicationEvent {
    private final TradesmanID contractorID;

    public AcceptProjectEvent(TradesmanID contractorID) {
        this.contractorID = contractorID;
    }

    public static AcceptProjectEvent of(TradesmanID contractorID) {
        return new AcceptProjectEvent(contractorID);
    }
}
