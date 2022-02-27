package org.esgi.trademe.contractor.application.retrieve.by_id;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.contractor.domain.ContractorID;

public final class RetrieveContractorByID implements Query {
    public final ContractorID id;

    public RetrieveContractorByID(ContractorID id) {
        this.id = id;
    }
}
