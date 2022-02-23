package org.esgi.trademe.tradesman.application.retrieve.all;


import org.esgi.trademe.tradesman.domain.TradesmanRepository;
import org.esgi.trademe.tradesman.exposition.TradesmanDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.List;
import java.util.stream.Collectors;

public final class RetrieveTradesmenHandler implements QueryHandler<RetrieveTradesmen, List<TradesmanDTO>> {

    private final TradesmanRepository tradesmanRepository;

    public RetrieveTradesmenHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public List<TradesmanDTO> handle(RetrieveTradesmen query) {
        return tradesmanRepository.findAll()
                .stream()
                .map(TradesmanDTO::of)
                .collect(Collectors.toList());
    }
}
