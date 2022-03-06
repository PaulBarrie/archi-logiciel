package org.esgi.trademe.project.application.update.assign_tradesmen;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.project.domain.ProjectID;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class AssignTradesmenToProject implements Command {
    private final ProjectID contractID;

    private AssignTradesmenToProject(ProjectID contractID) {
        this.contractID = contractID;
    }

    public static AssignTradesmenToProject of(ProjectID contractID) {
        return new AssignTradesmenToProject(contractID);
    }

    public ProjectID getProjectID() {
        return contractID;
    }
}
