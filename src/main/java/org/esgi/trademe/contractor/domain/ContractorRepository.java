package org.esgi.trademe.contractor.domain;

import org.esgi.trademe.kernel.Repository;

import java.util.List;

public interface ContractorRepository extends Repository<ContractorID, Contractor> {
    List<Contractor> findAll();
    List<Contractor> findByEducationOrExperience(List<WorkDomain> workDomain);
    void addEducation(ContractorID contractorID, WorkDomain workDomain, EducationLevel educationLevel);
    void addExperience(ContractorID contractorID, WorkDomain workDomain, Integer experienceYear);
}
