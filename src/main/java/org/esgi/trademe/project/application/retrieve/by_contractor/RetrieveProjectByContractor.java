package org.esgi.trademe.project.application.retrieve.by_contractor;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.query.Query;

public class RetrieveProjectByContractor implements Query {
    private final ContractorID contractorID;

    public RetrieveProjectByContractor(ContractorID contractorID) {
        this.contractorID = contractorID;
    }

    public ContractorID getContractorID() {
        return contractorID;
    }
}
