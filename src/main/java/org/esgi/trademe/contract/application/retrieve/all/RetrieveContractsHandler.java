package org.esgi.trademe.contract.application.retrieve.all;


import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.contract.exposition.ContractsDTO;
import org.esgi.trademe.kernel.query.QueryHandler;


public final class RetrieveContractsHandler implements QueryHandler<RetrieveContracts, ContractsDTO> {

    private final ContractRepository contractRepository;

    public RetrieveContractsHandler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ContractsDTO handle(RetrieveContracts query) {
        return ContractsDTO.of(contractRepository.findAll());
    }
}
