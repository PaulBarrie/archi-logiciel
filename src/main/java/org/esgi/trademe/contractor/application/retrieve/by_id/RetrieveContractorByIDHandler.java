package org.esgi.trademe.contractor.application.retrieve.by_id;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.exposition.ContractorDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.List;

public final class RetrieveContractorByIDHandler implements QueryHandler<RetrieveContractorByID, ContractorDTO> {

    private final ContractorRepository contractorRepository;

    public RetrieveContractorByIDHandler(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }


    @Override
    public ContractorDTO handle(RetrieveContractorByID query) {
        Contractor contractor = contractorRepository.findById(query.getId());
        return ContractorDTO.of(contractor);
    }
}
