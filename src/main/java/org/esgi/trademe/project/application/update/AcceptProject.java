package org.esgi.trademe.project.application.update;


import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class AcceptProject implements Command {
    private final ProjectID contractID;

    private AcceptProject(ProjectID contractID) {
        this.contractID = contractID;
    }

    public static AcceptProject of(ProjectID contractID) {
        return new AcceptProject(contractID);
    }

    public ProjectID getContractID() {
        return contractID;
    }
}
