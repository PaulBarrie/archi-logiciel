package org.esgi.trademe.project.application.update;


import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.trademan.domain.TradesmanID;

public final class ActivateProjectEvent implements ApplicationEvent {
    private final TradesmanID contractorID;

    public ActivateProjectEvent(TradesmanID contractorID) {
        this.contractorID = contractorID;
    }

    public static ActivateProjectEvent of(TradesmanID contractorID) {
        return new ActivateProjectEvent(contractorID);
    }
}
