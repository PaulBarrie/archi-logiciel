package org.esgi.trademe.tradesman.application.create.experience;



import org.esgi.trademe.tradesman.domain.*;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class AddTradesmanExperienceCommandHandler implements CommandHandler<AddTradesmanExperience, Void> {

    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    private AddTradesmanExperienceCommandHandler(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.tradesmanRepository = tradesmanRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public static AddTradesmanExperienceCommandHandler of(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AddTradesmanExperienceCommandHandler(tradesmanRepository, eventEventDispatcher);
    }

    public Void handle(AddTradesmanExperience addTradesmanExperience) {
        tradesmanRepository.addExperience(addTradesmanExperience.getTradesmanID(), addTradesmanExperience.getWorkDomain(),
                addTradesmanExperience.getExperienceYear());
        eventEventDispatcher.dispatch(new AddTradesmanExperienceEvent(addTradesmanExperience.getTradesmanID()));
        return null;
    }
}
