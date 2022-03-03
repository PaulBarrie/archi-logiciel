package org.esgi.trademe.tradesman.application.create;



import org.esgi.trademe.tradesman.domain.*;
import org.esgi.trademe.tradesman.validation.TradesmanHandler;
import org.esgi.trademe.tradesman.validation.tradesman.TradesmanDataHandler;
import org.esgi.trademe.tradesman.validation.tradesman.TradesmanUnicityHandler;
import org.esgi.trademe.tradesman.validation.credentials.TradesmanCredentialsDataHandler;
import org.esgi.trademe.tradesman.validation.credentials.TradesmanUsernameUnicityHandler;
import org.esgi.trademe.kernel.command.CommandHandler;
import org.esgi.trademe.kernel.event.Event;
import org.esgi.trademe.kernel.event.EventDispatcher;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.security.NoSuchAlgorithmException;

public final class CreateTradesmanCommandHandler implements CommandHandler<CreateTradesman, Tradesman> {
    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventDispatcher;
    private final TradesmanHandler handler;

    private CreateTradesmanCommandHandler(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.tradesmanRepository = tradesmanRepository;
        this.eventDispatcher = eventEventDispatcher;
        this.handler  = new TradesmanDataHandler();
        handler.setNext(new TradesmanUnicityHandler(tradesmanRepository))
                .setNext(new TradesmanCredentialsDataHandler())
                .setNext(new TradesmanUsernameUnicityHandler(tradesmanRepository));
    }

    public static CreateTradesmanCommandHandler of(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventDispatcher) {
        return new CreateTradesmanCommandHandler(tradesmanRepository, eventDispatcher);
    }

    public Tradesman handle(CreateTradesman createTradesman) throws NoSuchAlgorithmException, InvalidEntryException {
        final TradesmanID tradesmanID = tradesmanRepository.nextIdentity();
        Tradesman tradesman =  Tradesman.of(tradesmanID, createTradesman.firstname, createTradesman.lastname, createTradesman.email,
                TradesmanCredentials.of(createTradesman.credentials.getUsername(), createTradesman.credentials.getPassword()),
                TradesmanAddress.of(createTradesman.address.getStreetNumber(), createTradesman.address.getStreetName(), createTradesman.address.getZipCode(),
                        createTradesman.address.getCity(), createTradesman.address.getCountry()));
        handler.check(tradesman);
        tradesmanRepository.add(tradesman);
        eventDispatcher.dispatch(new CreateTradesmanEvent(tradesmanID));

        return tradesman;
    }
}
