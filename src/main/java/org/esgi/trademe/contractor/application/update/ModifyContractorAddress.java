package org.esgi.trademe.contractor.application.update;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.contractor.exposition.ContractorAddressDTO;

public final class ModifyContractorAddress implements Command {

    public final int contractorId;
    public final ContractorAddressDTO address;

    private ModifyContractorAddress(int contractorId, ContractorAddressDTO address) {
        this.contractorId = contractorId;
        this.address = address;
    }

    public static ModifyContractorAddress of(int contractorId, ContractorAddressDTO address) {
        return new ModifyContractorAddress(contractorId, address);
    }
}
