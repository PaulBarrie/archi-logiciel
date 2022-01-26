package org.esgi.trademe.contract.application.retrieve.by_id;


import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.exposition.ContractDTO;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.query.QueryHandler;

public class RetrieveContractByIDHandler implements QueryHandler<RetrieveContractByID, ContractDTO> {

    private final ContractRepository contractRepository;

    public RetrieveContractByIDHandler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public ContractDTO handle(RetrieveContractByID query) {
        Contract contract = contractRepository.findById(query.getId());
        return ContractDTO.of(contract);
    }
}
