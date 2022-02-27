package org.esgi.trademe.project.application.update;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.project.domain.ProjectID;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class ActivateProject implements Command {
    private final ProjectID contractID;

    private ActivateProject(ProjectID contractID) {
        this.contractID = contractID;
    }

    public static ActivateProject of(ProjectID contractID) {
        return new ActivateProject(contractID);
    }

    public ProjectID getProjectID() {
        return contractID;
    }
}
