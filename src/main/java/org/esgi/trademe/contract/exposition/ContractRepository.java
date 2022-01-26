package org.esgi.trademe.contract.exposition;

import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.kernel.Repository;
import org.esgi.trademe.contract.domain.ContractStatus;

import java.util.List;

public interface ContractRepository extends Repository<ContractID, Contract> {
    List<Contract> findAll();
    Contract findById(ContractID id);
    Contract update(ContractID contractID, Contract contract);
    List<Contract> findByTradesman(TradesmanID tradesmanID);
    List<Contract> findByStatus(ContractStatus status);
}
