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
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;

    public CreateProject(ContractorID contractorID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.contractorID = contractorID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
    }

    public static CreateProject of(ContractorID contractorID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new CreateProject(contractorID, hourlyWage, hoursPerMonth, workDomain);
    }

    public ContractorID getContractorID() {
        return contractorID;
    }


    public Float getHourlyWage() {
        return hourlyWage;
    }

    public Integer getHoursPerMonth() {
        return hoursPerMonth;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }
}
