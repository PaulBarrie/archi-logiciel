package org.esgi.trademe.trademan.application.create.education_level;



import org.esgi.trademe.trademan.domain.*;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;

public final class AddTradesmanEducationLevelCommandHandler implements CommandHandler<AddTradesmanEducationLevel, Void> {

    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    private AddTradesmanEducationLevelCommandHandler(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.tradesmanRepository = tradesmanRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public static AddTradesmanEducationLevelCommandHandler of(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        return new AddTradesmanEducationLevelCommandHandler(tradesmanRepository, eventEventDispatcher);
    }

    public Void handle(AddTradesmanEducationLevel addTradesmanEducationLevel) {
        tradesmanRepository.addEducation(addTradesmanEducationLevel.getTradesmanID(), addTradesmanEducationLevel.getWorkDomain(),
                addTradesmanEducationLevel.getEducationLevel());
        eventEventDispatcher.dispatch(new AddTradesmanEducationLevelEvent(addTradesmanEducationLevel.getTradesmanID()));
        return null;
    }
}
