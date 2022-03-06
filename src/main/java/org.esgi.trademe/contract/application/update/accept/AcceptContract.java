package org.esgi.trademe.contract.application.update.accept;


import org.esgi.trademe.contract.domain.ContractID;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class AcceptContract implements Command {
    private final ContractID contractID;

    private AcceptContract(ContractID contractID) {
        this.contractID = contractID;
    }

    public static AcceptContract of(ContractID contractID) {
        return new AcceptContract(contractID);
    }

    public ContractID getContractID() {
        return contractID;
    }
}
