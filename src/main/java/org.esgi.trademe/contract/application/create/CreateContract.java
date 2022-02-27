package org.esgi.trademe.contract.application.create;


import org.esgi.trademe.project.domain.ProjectID;
import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.tradesman.domain.WorkDomain;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateContract implements Command {
    private final ProjectID projectID;
    private final Float hourlyWage;
    private final Integer nbHours;
    private final WorkDomain workDomain;

    public CreateContract(ProjectID projectID, Float hourlyWage, Integer nbHours, WorkDomain workDomain) {
        this.projectID = projectID;
        this.hourlyWage = hourlyWage;
        this.nbHours = nbHours;
        this.workDomain = workDomain;
    }

    public static CreateContract of(ProjectID projectID, Float hourlyWage, Integer nbHours, WorkDomain workDomain) {
        return new CreateContract(projectID, hourlyWage, nbHours, workDomain);
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
}
