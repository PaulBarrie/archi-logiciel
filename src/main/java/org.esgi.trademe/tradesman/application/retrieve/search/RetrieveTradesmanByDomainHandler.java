package org.esgi.trademe.tradesman.application.retrieve.search;


import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.tradesman.domain.TradesmanRepository;
import org.esgi.trademe.tradesman.exposition.TradesmanDTO;
import org.esgi.trademe.tradesman.exposition.TradesmenDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.List;

public final class RetrieveTradesmanByDomainHandler implements QueryHandler<RetrieveTradesmanByDomain, TradesmenDTO> {

    private final TradesmanRepository tradesmanRepository;

    public RetrieveTradesmanByDomainHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public TradesmenDTO handle(RetrieveTradesmanByDomain query) {
        List<Tradesman> tradesmans = tradesmanRepository.findByEducationOrExperience(query.getDomains());

        TradesmenDTO tradesmansDTO = new TradesmenDTO();
        for (Tradesman tradesman: tradesmans) {
            tradesmansDTO.tradesmen.add(TradesmanDTO.of(tradesman));
        }
        return tradesmansDTO;
    }
}
