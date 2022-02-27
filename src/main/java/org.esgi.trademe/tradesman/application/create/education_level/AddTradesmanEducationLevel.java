package org.esgi.trademe.tradesman.application.create.education_level;


import org.esgi.trademe.tradesman.domain.TradesmanID;
import org.esgi.trademe.tradesman.domain.EducationLevel;
import org.esgi.trademe.tradesman.domain.WorkDomain;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class AddTradesmanEducationLevel implements Command {
    private final TradesmanID tradesmanID;
    private final WorkDomain workDomain;
    private final EducationLevel educationLevel;

    public AddTradesmanEducationLevel(TradesmanID tradesmanID, WorkDomain workDomain, EducationLevel educationLevel) {
        this.tradesmanID = tradesmanID;
        this.workDomain = workDomain;
        this.educationLevel = educationLevel;
    }

    public static AddTradesmanEducationLevel of(TradesmanID tradesmanID, WorkDomain workDomain, EducationLevel educationLevel) {
        return new AddTradesmanEducationLevel(tradesmanID, workDomain, educationLevel);
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }
}
