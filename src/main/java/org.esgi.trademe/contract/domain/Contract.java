package org.esgi.trademe.contract.domain;



import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.tradesman.domain.WorkDomain;
import org.esgi.trademe.kernel.Entity;

import java.util.Objects;

public final class Contract implements Entity<ContractID> {
    private final ContractID contractID;
    private final ProjectID projectID;
    private final Float hourlyWage;
    private final Integer nbHours;
    private final WorkDomain workDomain;
    private TradesmanID tradesmanID;
    private ContractStatus contractStatus;

    public Contract(ContractID contractID, ProjectID projectID, Float hourlyWage, Integer nbHours, WorkDomain workDomain) {
        this.contractID = contractID;
        this.projectID = projectID;
        this.hourlyWage = hourlyWage;
        this.nbHours = nbHours;
        this.workDomain = workDomain;
        this.contractStatus = ContractStatus.PENDING;
    }

    public static Contract of(ContractID contractID, ProjectID projectID, Float hourlyWage, Integer nbHours, WorkDomain workDomain) {
        return new Contract(contractID, projectID, hourlyWage, nbHours, workDomain);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract tradesman = (Contract) o;
        return Objects.equals(contractID, tradesman.contractID)
                && Objects.equals(projectID, tradesman.projectID) && Objects.equals(hourlyWage, tradesman.hourlyWage)
                && Objects.equals(nbHours, tradesman.nbHours) && Objects.equals(workDomain, tradesman.workDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractID, projectID, contractID, hourlyWage, nbHours, workDomain);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + contractID.toString() +
                ", project_id='" + projectID.toString() + '\'' +
                ", tradesman_id='" + contractID.toString() + '\'' +
                ", hourly_wage'" + hourlyWage + '\'' +
                ", number_hours='" + nbHours + '\'' +
                ", work_domain=" + workDomain +
                '}';
    }

    public ContractID getContractID() {
        return contractID;
    }

    public ProjectID getProjectID() {
        return projectID;
    }

    public Float getHourlyWage() {
        return hourlyWage;
    }

    public Integer getNbHours() {
        return nbHours;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }

    @Override
    public ContractID id() {
        return contractID;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
}
