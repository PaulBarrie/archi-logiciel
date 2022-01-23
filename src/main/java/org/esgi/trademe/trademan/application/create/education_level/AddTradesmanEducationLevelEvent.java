package org.esgi.trademe.trademan.application.create.education_level;


import org.esgi.trademe.trademan.domain.TradesmanID;
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
