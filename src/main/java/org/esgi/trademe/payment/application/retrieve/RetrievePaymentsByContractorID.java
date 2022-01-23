package org.esgi.trademe.payment.application.retrieve;


import org.esgi.trademe.kernel.query.Query;
import org.esgi.trademe.contractor.domain.ContractorID;

public final class RetrievePaymentsByContractorID implements Query {
    public final ContractorID contractorID;

    public RetrievePaymentsByContractorID(ContractorID contractorID) {
        this.contractorID = contractorID;
    }
}
