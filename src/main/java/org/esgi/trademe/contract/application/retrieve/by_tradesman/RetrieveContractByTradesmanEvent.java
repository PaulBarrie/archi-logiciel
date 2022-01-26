package org.esgi.trademe.contract.application.retrieve.by_tradesman;

import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public class RetrieveContractByTradesmanEvent implements ApplicationEvent {
    private final TradesmanID tradesmanID;

    public RetrieveContractByTradesmanEvent(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public static RetrieveContractByTradesmanEvent of(TradesmanID tradesmanID) {
        return new RetrieveContractByTradesmanEvent(tradesmanID);
    }
}
