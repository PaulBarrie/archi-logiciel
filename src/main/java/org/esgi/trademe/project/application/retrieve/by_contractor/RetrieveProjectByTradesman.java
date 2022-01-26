package org.esgi.trademe.project.application.retrieve.by_contractor;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.trademan.domain.TradesmanID;

public class RetrieveProjectByTradesman implements Query {
    private final TradesmanID tradesmanID;

    public RetrieveProjectByTradesman(TradesmanID tradesmanID) {
        this.tradesmanID = tradesmanID;
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }
}
