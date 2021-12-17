package org.esgi.trademe.contractor.application.create.education_level;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.EducationLevel;
import org.esgi.trademe.contractor.domain.WorkDomain;
import org.esgi.trademe.contractor.exposition.AddressDTO;
import org.esgi.trademe.contractor.exposition.EducationDTO;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class AddContractorEducationLevel implements Command {
    private final ContractorID contractorID;
    private final WorkDomain workDomain;
    private final EducationLevel educationLevel;

    public AddContractorEducationLevel(ContractorID contractorID, WorkDomain workDomain, EducationLevel educationLevel) {
        this.contractorID = contractorID;
        this.workDomain = workDomain;
        this.educationLevel = educationLevel;
    }

    public static AddContractorEducationLevel of(ContractorID contractorID, WorkDomain workDomain, EducationLevel educationLevel) {
        return new AddContractorEducationLevel(contractorID, workDomain, educationLevel);
    }

    public ContractorID getContractorID() {
        return contractorID;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }
}
