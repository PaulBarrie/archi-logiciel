package org.esgi.trademe.tradesman.application.create.education_level;


import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class AddTradesmanEducationLevelEvent implements ApplicationEvent {
    private final TradesmanID tradesmanID;

    public AddTradesmanEducationLevelEvent(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public static AddTradesmanEducationLevelEvent of(TradesmanID tradesmanID) {
        return new AddTradesmanEducationLevelEvent(tradesmanID);
    }
}
