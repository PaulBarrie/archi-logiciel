package org.esgi.trademe.contract.application.update;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class AcceptContractEvent implements ApplicationEvent {
    private final TradesmanID contractorID;

    public AcceptContractEvent(TradesmanID contractorID) {
        this.contractorID = contractorID;
    }

    public static AcceptContractEvent of(TradesmanID contractorID) {
        return new AcceptContractEvent(contractorID);
    }
}
