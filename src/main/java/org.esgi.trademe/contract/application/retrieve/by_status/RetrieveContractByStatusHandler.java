package org.esgi.trademe.contract.application.retrieve.by_status;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.contract.exposition.ContractsDTO;

import java.util.List;

public final class RetrieveContractByStatusHandler implements QueryHandler<RetrieveContractByStatus, ContractsDTO> {

    private final ContractRepository contractRepository;

    public RetrieveContractByStatusHandler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ContractsDTO handle(RetrieveContractByStatus query) {
        List<Contract> contracts = contractRepository.findByStatus(query.getStatus());
        return ContractsDTO.of(contracts);
    }
}
