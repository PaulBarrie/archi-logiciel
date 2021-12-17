package org.esgi.trademe.contractor.infrastructure;


import org.esgi.trademe.contractor.domain.*;
import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryContractorRepository implements ContractorRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ContractorID, Contractor> data = new ConcurrentHashMap<>();

    @Override
    public ContractorID nextIdentity() {
        return  ContractorID.of(count.incrementAndGet());
    }

    @Override
    public Contractor findById(ContractorID id) {
        final Contractor contractor = data.get(id);
        if (contractor == null) {
            throw NoSuchEntityException.withId(id);
        }
        return contractor;
    }

    @Override
    public void add(Contractor contractor) {
        data.put(contractor.getId(), contractor);
    }

    @Override
    public void delete(ContractorID id) {
        data.remove(id);
    }

    @Override
    public List<Contractor> findAll() {
        return List.copyOf(data.values());
    }

    public static boolean hasEducationDomain(Contractor contractor, List<WorkDomain> workDomains) {
        boolean res = false;
        if(contractor.getEducation() == null) {
            return false;
        }
        for(WorkDomain workDomain: workDomains) {
            if(contractor.getEducation().getEducationLevel() != null) {
                  res = contractor.getEducation().getEducationLevel().containsKey(workDomain);
                    System.out.println(res);

            } else if(contractor.getEducation().getYearExperiences() != null) {
                  res = contractor.getEducation().getYearExperiences().containsKey(workDomain);
            }
            if(res) {
                return res;
            }
        }
        return res;
    }

    @Override
    public List<Contractor> findByEducationOrExperience(List<WorkDomain> workDomains) {
        return List.copyOf(data.values().stream()
                .filter(contractor -> hasEducationDomain(contractor, workDomains))
                .collect(Collectors.toList()));
    }

    @Override
    public void addEducation(ContractorID contractorID, WorkDomain workDomain, EducationLevel educationLevel) {
        Contractor contractor = findById(contractorID);
        Map<WorkDomain, EducationLevel> education = new HashMap<>();
        if(contractor.getEducation() ==  null) {
            contractor.setEducation(Education.of(new HashMap<>(), new HashMap<>()));
        } else if(contractor.getEducation().getEducationLevel() == null) {
            contractor.getEducation().setEducationLevel(new HashMap<>());
        } else {
            education = contractor.getEducation().getEducationLevel();
        }
        education.put(workDomain, educationLevel);
        contractor.setEducation(Education.of(education, contractor.getEducation().getYearExperiences()));
        add(contractor);

        Map<WorkDomain, EducationLevel> educationDetails = contractor.getEducation().getEducationLevel();
        educationDetails.put(workDomain, educationLevel);
        contractor.setEducation(Education.of(educationDetails, contractor.getEducation().getYearExperiences()));
        add(contractor);
    }

    @Override
    public void addExperience(ContractorID contractorID, WorkDomain workDomain, Integer experienceYear) {
        Contractor contractor = findById(contractorID);
        Map<WorkDomain, Integer> experience = new HashMap<>();
        if(contractor.getEducation() ==  null) {
            contractor.setEducation(Education.of(new HashMap<>(), new HashMap<>()));
        } else if(contractor.getEducation().getYearExperiences() == null) {
            contractor.getEducation().setYearExperiences(new HashMap<>());
        } else {
            experience = contractor.getEducation().getYearExperiences();
        }
        experience.put(workDomain, experienceYear);
        contractor.setEducation(Education.of(contractor.getEducation().getEducationLevel(), experience));
        add(contractor);
    }

}
