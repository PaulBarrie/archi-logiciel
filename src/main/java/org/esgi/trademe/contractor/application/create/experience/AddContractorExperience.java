package org.esgi.trademe.contractor.application.create.experience;


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
public final class AddContractorExperience implements Command {
    private final ContractorID contractorID;
    private final WorkDomain workDomain;
    private final Integer experienceYear;

    public AddContractorExperience(ContractorID contractorID, WorkDomain workDomain, Integer experienceYear) {
        this.contractorID = contractorID;
        this.workDomain = workDomain;
        this.experienceYear = experienceYear;
    }

    public static AddContractorExperience of(ContractorID contractorID, WorkDomain workDomain, Integer experienceYear) {
        return new AddContractorExperience(contractorID, workDomain, experienceYear);
    }

    public ContractorID getContractorID() {
        return contractorID;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }

    public Integer getExperienceYear() {
        return experienceYear;
    }
}
