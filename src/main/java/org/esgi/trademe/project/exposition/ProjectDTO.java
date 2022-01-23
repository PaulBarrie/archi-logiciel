package org.esgi.trademe.project.exposition;

import org.esgi.trademe.project.domain.Project;

@SuppressWarnings("all")
public final class ProjectDTO {

    public final Project project;

    public ProjectDTO(Project project) {
        this.project = project;
    }


    public static ProjectDTO of(Project project){
        return new ProjectDTO(project);
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + project.getContractID().toString() + '\'' +
                ", contractor_id='" + project.getContractorID().toString() + '\'' +
                ", tradesman_id='" + project.getTradesmanID().toString() + '\'' +
                ", hourly_work='" + project.getHourlyWage() + '\'' +
                ", hours_per_month='" + project.getHoursPerMonth() + '\'' +
                ", work_domain=" + project.getWorkDomain() +
                '}';
    }
}
