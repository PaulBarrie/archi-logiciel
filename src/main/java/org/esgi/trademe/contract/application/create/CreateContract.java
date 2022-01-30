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
    private final TradesmanID tradesmanID;
    private final Float hourlyWage;
    private final Integer hoursPerMonth;
    private final WorkDomain workDomain;

    public CreateContract(ProjectID projectID, TradesmanID tradesmanID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        this.projectID = projectID;
        this.tradesmanID = tradesmanID;
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
        this.workDomain = workDomain;
    }

    public static CreateContract of(ProjectID projectID, TradesmanID tradesmanID, Float hourlyWage, Integer hoursPerMonth, WorkDomain workDomain) {
        return new CreateContract(projectID, tradesmanID, hourlyWage, hoursPerMonth, workDomain);
    }

    public ProjectID getProjectID() {
        return projectID;
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
