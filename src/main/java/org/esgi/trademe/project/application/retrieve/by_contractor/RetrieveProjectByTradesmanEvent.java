package org.esgi.trademe.project.application.retrieve.by_contractor;

import org.esgi.trademe.kernel.event.ApplicationEvent;
import org.esgi.trademe.trademan.domain.TradesmanID;

public class RetrieveProjectByTradesmanEvent implements ApplicationEvent {
    private final TradesmanID tradesmanID;

    public RetrieveProjectByTradesmanEvent(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public static RetrieveProjectByTradesmanEvent of(TradesmanID tradesmanID) {
        return new RetrieveProjectByTradesmanEvent(tradesmanID);
    }
}
