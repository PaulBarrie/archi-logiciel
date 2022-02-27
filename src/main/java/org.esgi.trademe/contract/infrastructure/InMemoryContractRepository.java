package org.esgi.trademe.contract.infrastructure;


import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.contract.domain.ContractStatus;
import org.esgi.trademe.contract.exposition.ContractRepository;
import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryContractRepository implements ContractRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ContractID, Contract> data = new ConcurrentHashMap<>();


    @Override
    public List<Contract> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public Contract update(ContractID contractID, Contract contract) {
        return null;
    }

    @Override
    public List<Contract> findByTradesman(TradesmanID tradesmanID) {
        return List.copyOf(data.values().stream()
                .filter(contract -> contract.getTradesmanID() == tradesmanID)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Contract> findByStatus(ContractStatus status) {
        return List.copyOf(data.values().stream()
                .filter(contract -> contract.getContractStatus() == status)
                .collect(Collectors.toList()));
    }

    @Override
    public List<Contract> findByProject(ProjectID projectID) {
        return List.copyOf(data.values().stream()
                .filter(contract -> contract.getProjectID().equals(projectID))
                .collect(Collectors.toList()));
    }
    

    @Override
    public ContractID nextIdentity() {
        return ContractID.of(count.incrementAndGet());
    }

    @Override
    public Contract findById(ContractID id) throws NoSuchEntityException {
        final Contract contract = data.get(id);
        if (contract == null) {
            throw NoSuchEntityException.withId(id);
        }
        return contract;
    }

    @Override
    public void add(Contract entity) {
        data.put(entity.getContractID(), entity);
    }

    @Override
    public void delete(ContractID id) {

    }
}
