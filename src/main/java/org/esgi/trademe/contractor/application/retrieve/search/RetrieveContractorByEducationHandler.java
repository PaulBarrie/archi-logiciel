package org.esgi.trademe.contractor.application.retrieve.search;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorRepository;
import org.esgi.trademe.contractor.exposition.ContractorDTO;
import org.esgi.trademe.contractor.exposition.ContractorsDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RetrieveContractorByEducationHandler implements QueryHandler<RetrieveContractorByEducation, ContractorsDTO> {

    private final ContractorRepository contractorRepository;

    public RetrieveContractorByEducationHandler(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @Override
    public ContractorsDTO handle(RetrieveContractorByEducation query) {
        List<Contractor> contractors = contractorRepository.findByEducationOrExperience(query.getDomains());

        ContractorsDTO contractorsDTO = new ContractorsDTO();
        for (Contractor contractor: contractors) {
            contractorsDTO.contractors.add(ContractorDTO.of(contractor));
        }
        return contractorsDTO;
    }
}
