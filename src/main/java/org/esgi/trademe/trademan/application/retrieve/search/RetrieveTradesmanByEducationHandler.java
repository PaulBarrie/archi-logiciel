package org.esgi.trademe.trademan.application.retrieve.search;


import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.domain.TradesmanRepository;
import org.esgi.trademe.trademan.exposition.TradesmanDTO;
import org.esgi.trademe.trademan.exposition.TradesmenDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.List;

public final class RetrieveTradesmanByEducationHandler implements QueryHandler<RetrieveTradesmanByEducation, TradesmenDTO> {

    private final TradesmanRepository tradesmanRepository;

    public RetrieveTradesmanByEducationHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public TradesmenDTO handle(RetrieveTradesmanByEducation query) {
        List<Tradesman> tradesmans = tradesmanRepository.findByEducationOrExperience(query.getDomains());

        TradesmenDTO tradesmansDTO = new TradesmenDTO();
        for (Tradesman tradesman: tradesmans) {
            tradesmansDTO.tradesmen.add(TradesmanDTO.of(tradesman));
        }
        return tradesmansDTO;
    }
}
