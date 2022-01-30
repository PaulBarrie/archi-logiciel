package org.esgi.trademe.tradesman.application.retrieve.all;


import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class RetrieveTradesmenEvent implements ApplicationEvent {
    private final TradesmanID tradesmanID;

    public RetrieveTradesmenEvent(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public static RetrieveTradesmenEvent of(TradesmanID tradesmanID) {
        return new RetrieveTradesmenEvent(tradesmanID);
    }
}
