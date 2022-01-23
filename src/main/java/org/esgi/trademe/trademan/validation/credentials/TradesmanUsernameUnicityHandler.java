package org.esgi.trademe.trademan.validation.credentials;

import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.domain.TradesmanRepository;
import org.esgi.trademe.trademan.validation.TradesmanHandler;
import org.esgi.trademe.kernel.exceptions.AlreadyUsedParameterException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.util.List;
import java.util.Objects;

public class TradesmanUsernameUnicityHandler extends TradesmanHandler {
    private TradesmanHandler next;
    private final TradesmanRepository tradesmanRepository;

    public TradesmanUsernameUnicityHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public void check(Tradesman entity) throws InvalidEntryException {
        List<Tradesman> tradesmans = tradesmanRepository.findAll();
        for (Tradesman tradesman : tradesmans) {
            if (Objects.equals(tradesman.getCredentials().getUsername(), entity.getCredentials().getUsername())) {
                throw AlreadyUsedParameterException.with("Username", entity.getCredentials().getUsername());
            }
        }
        checkNext(entity);
    }
}
