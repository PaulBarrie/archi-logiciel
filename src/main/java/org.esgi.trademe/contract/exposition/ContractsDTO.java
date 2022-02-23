package org.esgi.trademe.contract.exposition;

import org.esgi.trademe.contract.domain.Contract;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public final class ContractsDTO {
    public List<Contract> contracts = new ArrayList<>();

    private ContractsDTO(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public static ContractsDTO of(List<Contract> contracts) {
        return new ContractsDTO(contracts);
    }
}
