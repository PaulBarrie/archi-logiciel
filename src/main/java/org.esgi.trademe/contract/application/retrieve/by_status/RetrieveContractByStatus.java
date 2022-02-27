package org.esgi.trademe.contract.application.retrieve.by_status;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.contract.domain.ContractStatus;

public final class RetrieveContractByStatus implements Query {
    private final ContractStatus status;

    public RetrieveContractByStatus(ContractStatus status) {
        this.status = status;
    }

    public ContractStatus getStatus() {
        return status;
    }
}
