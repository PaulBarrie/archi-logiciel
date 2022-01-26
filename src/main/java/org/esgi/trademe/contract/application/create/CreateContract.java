package org.esgi.trademe.contract.application.create;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.trademan.domain.WorkDomain;
import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.contractor.domain.ContractorID;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateContract implements Command {
    private final ContractorID contractorID;
    private final TradesmanID tradesmanID;
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;

    public CreateContract(ContractorID contractorID, TradesmanID tradesmanID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.contractorID = contractorID;
        this.tradesmanID = tradesmanID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
    }

    public static CreateContract of(ContractorID contractorID, TradesmanID tradesmanID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new CreateContract(contractorID, tradesmanID, hourlyWage, hoursPerMonth, workDomain);
    }

    public ContractorID getContractorID() {
        return contractorID;
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
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
