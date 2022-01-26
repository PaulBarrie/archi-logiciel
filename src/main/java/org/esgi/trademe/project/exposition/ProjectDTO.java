package org.esgi.trademe.project.exposition;

import org.esgi.trademe.project.domain.Project;

@SuppressWarnings("all")
public final class ProjectDTO {

    public final Project contract;

    public ProjectDTO(Project contract) {
        this.contract = contract;
    }


    public static ProjectDTO of(Project contract){
        return new ProjectDTO(contract);
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + contract.getProjectID().toString() + '\'' +
                ", contractor_id='" + contract.getContractorID().toString() + '\'' +
                ", tradesman_id='" + contract.getTradesmanID().toString() + '\'' +
                ", hourly_work='" + contract.getHourlyWage() + '\'' +
                ", hours_per_month='" + contract.getHoursPerMonth() + '\'' +
                ", work_domain=" + contract.getWorkDomain() +
                '}';
    }
}
