package org.esgi.trademe.project.application.retrieve.by_contractor;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.query.Query;

public final class RetrieveProjectByContractor implements Query {
    private final ContractorID contractorID;

    private RetrieveProjectByContractor(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public static RetrieveProjectByContractor of(ContractorID contractorID) {
        return new RetrieveProjectByContractor(contractorID);
    }

    public ContractorID getContractorID() {
        return contractorID;
    }
}
