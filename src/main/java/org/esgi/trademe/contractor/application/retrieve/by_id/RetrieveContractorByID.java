package org.esgi.trademe.contractor.application.retrieve.by_id;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.query.Query;

public final class RetrieveContractorByID implements Query {
    private final ContractorID id;

    public RetrieveContractorByID(ContractorID id) {
        this.id = id;
    }

    public ContractorID getId() {
        return id;
    }
}
