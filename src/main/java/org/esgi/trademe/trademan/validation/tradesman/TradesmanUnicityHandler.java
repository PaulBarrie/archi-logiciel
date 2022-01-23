package org.esgi.trademe.trademan.validation.tradesman;

import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.domain.TradesmanRepository;
import org.esgi.trademe.trademan.validation.TradesmanHandler;
import org.esgi.trademe.kernel.exceptions.AlreadyUsedParameterException;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;


import java.util.List;
import java.util.Objects;

public final class TradesmanUnicityHandler extends TradesmanHandler {
    private final TradesmanRepository tradesmanRepository;

    public TradesmanUnicityHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }


    @Override
    public void check(Tradesman tradesman) throws InvalidEntryException {
        List<Tradesman> existingTradesman = tradesmanRepository.findAll();
        for (Tradesman m : existingTradesman) {
            if (Objects.equals(tradesman.getEmail(), m.getEmail())) {
                throw  AlreadyUsedParameterException.forField("Email", tradesman.getEmail());
            }
            if (Objects.equals(tradesman.getFirstname(), m.getFirstname()) & Objects.equals(tradesman.getLastname(), m.getLastname())) {
                throw new AlreadyUsedParameterException("Tradesman " + tradesman.getFirstname() + " " + tradesman.getLastname() + " already exists.");
            }
        }
        checkNext(tradesman);
    }
}
