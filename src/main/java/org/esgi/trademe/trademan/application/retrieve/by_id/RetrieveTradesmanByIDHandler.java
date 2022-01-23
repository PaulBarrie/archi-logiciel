package org.esgi.trademe.trademan.application.retrieve.by_id;


import org.esgi.trademe.trademan.domain.Tradesman;
import org.esgi.trademe.trademan.domain.TradesmanRepository;
import org.esgi.trademe.trademan.exposition.TradesmanDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

public final class RetrieveTradesmanByIDHandler implements QueryHandler<RetrieveTradesmanByID, TradesmanDTO> {

    private final TradesmanRepository tradesmanRepository;

    public RetrieveTradesmanByIDHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }


    @Override
    public TradesmanDTO handle(RetrieveTradesmanByID query) {
        Tradesman tradesman = tradesmanRepository.findById(query.getId());
        return TradesmanDTO.of(tradesman);
    }
}
