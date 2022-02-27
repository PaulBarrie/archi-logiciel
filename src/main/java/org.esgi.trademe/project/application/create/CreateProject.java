package org.esgi.trademe.project.application.create;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.tradesman.domain.WorkDomain;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateProject implements Command {
    private final ContractorID contractorID;
    private final Integer dayDuration;
    private final String Location;

    public CreateProject(ContractorID contractorID, Integer dayDuration, String location) {
        this.contractorID = contractorID;
        this.dayDuration = dayDuration;
        Location = location;
    }


    public static CreateProject of(ContractorID contractorID, Integer dayDuration, String location) {
        return new CreateProject(contractorID, dayDuration, location);
    }
    public ContractorID getContractorID() {
        return contractorID;
    }

    public Integer getDayDuration() {
        return dayDuration;
    }

    public String getLocation() {
        return Location;
    }
}
