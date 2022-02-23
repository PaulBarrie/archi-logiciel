package org.esgi.trademe.contract.application.retrieve.by_tradesman;


import org.esgi.trademe.kernel.query.QueryHandler;
import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.contract.exposition.ContractsDTO;

import java.util.List;

public class RetrieveContractByTradesmanHandler implements QueryHandler<RetrieveContractByTradesman, ContractsDTO> {

    private final ContractRepository contractRepository;

    public RetrieveContractByTradesmanHandler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ContractsDTO handle(RetrieveContractByTradesman query) {
        List<Contract> contracts = contractRepository.findByTradesman(query.getTradesmanID());
        return ContractsDTO.of(contracts);
    }
}
