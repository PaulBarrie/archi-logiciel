package org.esgi.trademe.project.domain;


import org.esgi.trademe.contract.domain.Contract;
import org.esgi.trademe.contractor.domain.ContractorID;

import org.esgi.trademe.kernel.Entity;

import java.util.List;
import java.util.Objects;

public final class Project implements Entity<ProjectID> {
    private final ProjectID projectID;
    private final ContractorID contractorID;
    private final Integer dayDuration;
    private final String Location;
    private List<Contract> contractList;
    private ProjectStatus projectStatus;

    public Project(ProjectID projectID, ContractorID contractorID, Integer dayDuration, String location) {
        this.projectID = projectID;
        this.contractorID = contractorID;
        this.dayDuration = dayDuration;
        Location = location;
        this.projectStatus = ProjectStatus.PENDING;
    }


    public static Project of(ProjectID projectID, ContractorID contractorID, Integer dayDuration, String location) {
        return new Project(projectID, contractorID, dayDuration, location);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project tradesman = (Project) o;
        return Objects.equals(projectID, tradesman.projectID)
                && Objects.equals(contractorID, tradesman.contractorID);

    }

    @Override
    public int hashCode() {
        return Objects.hash(projectID, contractorID);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + projectID.toString() +
                ", contract_id='" + contractorID.toString() + '\'' +
                ", tradesman_id='" + projectID.toString() + '\'' +
                ", contracts='" + contractList + '\'' +
                '}';
    }

    public ProjectID getProjectID() {
        return projectID;
    }

    public ContractorID getContractorID() {
        return contractorID;
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

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

}

