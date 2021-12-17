package org.esgi.trademe.project.application.create;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.WorkDomain;
import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.member.domain.MemberID;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateProject implements Command {
    private final MemberID memberID;
    private final ContractorID contractorID;
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;

    public CreateProject(MemberID memberID, ContractorID contractorID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.memberID = memberID;
        this.contractorID = contractorID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
    }

    public static CreateProject of(MemberID memberID, ContractorID contractorID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new CreateProject(memberID, contractorID, hourlyWage, hoursPerMonth, workDomain);
    }

    public MemberID getMemberID() {
        return memberID;
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
