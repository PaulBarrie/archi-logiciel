package org.esgi.trademe.tradesman.application.create;


import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class CreateTradesmanEvent implements ApplicationEvent {
    private final TradesmanID tradesmanID;

    public CreateTradesmanEvent(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public static CreateTradesmanEvent of(TradesmanID tradesmanID) {
        return new CreateTradesmanEvent(tradesmanID);
    }
}
