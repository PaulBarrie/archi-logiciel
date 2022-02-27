package org.esgi.trademe.contract.application.retrieve.by_project;


import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.contract.exposition.ContractsDTO;
import org.esgi.trademe.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveContractByProjectHandler implements QueryHandler<RetrieveContractByProject, ContractsDTO> {

    private final ContractRepository contractRepository;

    public RetrieveContractByProjectHandler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ContractsDTO handle(RetrieveContractByProject query) {
        List<Contract> contracts = contractRepository.findByProject(query.getProjectID());
        return ContractsDTO.of(contracts);
    }
}
