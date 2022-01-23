package org.esgi.trademe.project.application.retrieve.by_tradesman;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.query.Query;

public class RetrieveProjectByTradesman implements Query {
    private final TradesmanID tradesmanID;

    public RetrieveProjectByTradesman(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }
}
