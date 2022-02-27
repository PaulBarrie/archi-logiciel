package org.esgi.trademe.contractor.application.retrieve.all;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.exposition.ContractorDTO;

import java.util.List;
import java.util.stream.Collectors;

public final class RetrieveContractorsHandler implements QueryHandler<RetrieveContractors, List<ContractorDTO>> {

    private final ContractorRepository contractorRepository;

    public RetrieveContractorsHandler(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public List<ContractorDTO> handle(RetrieveContractors query) {
        return contractorRepository.findAll()
                .stream()
                .map(ContractorDTO::of)
                .collect(Collectors.toList());
    }
}
