package org.esgi.trademe.contract.application.retrieve.by_tradesman;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.query.Query;

public class RetrieveContractByTradesman implements Query {
    private final TradesmanID tradesmanID;

    public RetrieveContractByTradesman(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }
}
