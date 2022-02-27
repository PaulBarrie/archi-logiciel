package org.esgi.trademe.project.application.retrieve.by_contractor;

import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.tradesman.domain.TradesmanID;

public class RetrieveProjectByContractorEvent implements ApplicationEvent {
    private final TradesmanID tradesmanID;

    public RetrieveProjectByContractorEvent(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public static RetrieveProjectByContractorEvent of(TradesmanID tradesmanID) {
        return new RetrieveProjectByContractorEvent(tradesmanID);
    }
}
