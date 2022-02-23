package org.esgi.trademe.contract.application.retrieve.by_id;


import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.kernel.query.Query;

public class RetrieveContractByID implements Query {
    private final ContractID id;

    public RetrieveContractByID(ContractID id) {
        this.id = id;
    }

    public ContractID getId() {
        return id;
    }
}
