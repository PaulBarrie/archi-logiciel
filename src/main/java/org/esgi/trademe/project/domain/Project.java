package org.esgi.trademe.project.domain;


import org.esgi.trademe.contractor.domain.ContractorID;

import org.esgi.trademe.kernel.Entity;
import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.trademan.domain.WorkDomain;

import java.util.Objects;

public final class Project implements Entity<ProjectID> {
    private final ProjectID projectID;
    private final ContractorID contractID;
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;
    private ProjectStatus projectStatus;

    public Project(ProjectID projectID, ContractorID contractID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.projectID = projectID;
        this.contractID = contractID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
        this.projectStatus = ProjectStatus.PENDING;
    }


    public static Project of(ProjectID projectID, ContractorID contractID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new Project(projectID, contractID, hourlyWage, hoursPerMonth, workDomain);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project tradesman = (Project) o;
        return Objects.equals(projectID, tradesman.projectID)
                && Objects.equals(contractID, tradesman.contractID) && Objects.equals(hourlyWage, tradesman.hourlyWage)
                && Objects.equals(hoursPerMonth, tradesman.hoursPerMonth) && Objects.equals(workDomain, tradesman.workDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectID, contractID, projectID, hourlyWage, hoursPerMonth, workDomain);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + projectID.toString() +
                ", contract_id='" + contractID.toString() + '\'' +
                ", tradesman_id='" + projectID.toString() + '\'' +
                ", hourly_work='" + hourlyWage + '\'' +
                ", hours_per_month='" + hoursPerMonth + '\'' +
                ", work_domain=" + workDomain +
                '}';
    }

    public ProjectID getProjectID() {
        return projectID;
    }

    public ContractorID getContractorID() {
        return contractID;
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
        return projectID;
    }

    public ProjectStatus getContractStatus() {
        return projectStatus;
    }

    public void setContractStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
}
