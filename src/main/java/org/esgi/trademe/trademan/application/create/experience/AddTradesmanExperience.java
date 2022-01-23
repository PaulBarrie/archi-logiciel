package org.esgi.trademe.trademan.application.create.experience;


import org.esgi.trademe.trademan.domain.TradesmanID;
import org.esgi.trademe.trademan.domain.WorkDomain;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class AddTradesmanExperience implements Command {
    private final TradesmanID tradesmanID;
    private final WorkDomain workDomain;
    private final Integer experienceYear;

    public AddTradesmanExperience(TradesmanID tradesmanID, WorkDomain workDomain, Integer experienceYear) {
        this.tradesmanID = tradesmanID;
        this.workDomain = workDomain;
        this.experienceYear = experienceYear;
    }

    public static AddTradesmanExperience of(TradesmanID tradesmanID, WorkDomain workDomain, Integer experienceYear) {
        return new AddTradesmanExperience(tradesmanID, workDomain, experienceYear);
    }

    public TradesmanID getTradesmanID() {
        return tradesmanID;
    }

    public WorkDomain getWorkDomain() {
        return workDomain;
    }

    public Integer getExperienceYear() {
        return experienceYear;
    }
}
