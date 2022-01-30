package org.esgi.trademe.tradesman.domain;

import org.esgi.trademe.kernel.Repository;

import java.util.List;

public interface TradesmanRepository extends Repository<TradesmanID, Tradesman> {
    List<Tradesman> findAll();
    List<Tradesman> findByEducationOrExperience(List<WorkDomain> workDomain);
    void addEducation(TradesmanID tradesmanID, WorkDomain workDomain, EducationLevel educationLevel);
    void addExperience(TradesmanID tradesmanID, WorkDomain workDomain, Integer experienceYear);
}
