package org.esgi.trademe.project.domain;



import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.WorkDomain;
import org.esgi.trademe.kernel.Entity;
import org.esgi.trademe.member.domain.MemberID;

import java.util.Objects;

public final class Project implements Entity<ProjectID> {
    private final ProjectID contractID;
    private final MemberID memberID;
    private final ContractorID contractorID;
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;
    private ProjectStatus contractStatus;

    public Project(ProjectID contractID, MemberID memberID, ContractorID contractorID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.contractID = contractID;
        this.memberID = memberID;
        this.contractorID = contractorID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
        this.contractStatus = ProjectStatus.PENDING;
    }


    public static Project of(ProjectID contractID, MemberID memberID, ContractorID contractorID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new Project(contractID, memberID, contractorID, hourlyWage, hoursPerMonth, workDomain);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project contractor = (Project) o;
        return Objects.equals(contractID, contractor.contractID) && Objects.equals(contractorID, contractor.contractorID)
                && Objects.equals(memberID, contractor.memberID) && Objects.equals(hourlyWage, contractor.hourlyWage)
                && Objects.equals(hoursPerMonth, contractor.hoursPerMonth) && Objects.equals(workDomain, contractor.workDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractID, memberID, contractID, hourlyWage, hoursPerMonth, workDomain);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + contractID.toString() +
                ", member_id='" + memberID.toString() + '\'' +
                ", contractor_id='" + contractID.toString() + '\'' +
                ", hourly_work='" + hourlyWage + '\'' +
                ", hours_per_month='" + hoursPerMonth + '\'' +
                ", work_domain=" + workDomain +
                '}';
    }

    public ProjectID getContractID() {
        return contractID;
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

    @Override
    public ProjectID id() {
        return contractID;
    }

    public ProjectStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ProjectStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
}
