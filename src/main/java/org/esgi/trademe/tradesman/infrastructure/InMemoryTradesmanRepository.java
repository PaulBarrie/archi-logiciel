package org.esgi.trademe.tradesman.infrastructure;


import org.esgi.trademe.tradesman.domain.*;
import org.esgi.trademe.kernel.exceptions.NoSuchEntityException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryTradesmanRepository implements TradesmanRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<TradesmanID, Tradesman> data = new ConcurrentHashMap<>();

    @Override
    public TradesmanID nextIdentity() {
        return  TradesmanID.of(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(TradesmanID id) {
        final Tradesman tradesman = data.get(id);
        if (tradesman == null) {
            throw NoSuchEntityException.withId(id);
        }
        return tradesman;
    }

    @Override
    public void add(Tradesman tradesman) {
        data.put(tradesman.getId(), tradesman);
    }

    @Override
    public void delete(TradesmanID id) {
        data.remove(id);
    }

    @Override
    public List<Tradesman> findAll() {
        return List.copyOf(data.values());
    }

    public static boolean hasEducationDomain(Tradesman tradesman, List<WorkDomain> workDomains) {
        boolean res = false;
        if(tradesman.getEducation() == null) {
            return false;
        }
        for(WorkDomain workDomain: workDomains) {
            if(tradesman.getEducation().getEducationLevel() != null) {
                  res = tradesman.getEducation().getEducationLevel().containsKey(workDomain);
                    System.out.println(res);

            } else if(tradesman.getEducation().getYearExperiences() != null) {
                  res = tradesman.getEducation().getYearExperiences().containsKey(workDomain);
            }
            if(res) {
                return res;
            }
        }
        return res;
    }

    @Override
    public List<Tradesman> findByEducationOrExperience(List<WorkDomain> workDomains) {
        return List.copyOf(data.values().stream()
                .filter(tradesman -> hasEducationDomain(tradesman, workDomains))
                .collect(Collectors.toList()));
    }

    @Override
    public void addEducation(TradesmanID tradesmanID, WorkDomain workDomain, EducationLevel educationLevel) {
        Tradesman tradesman = findById(tradesmanID);
        Map<WorkDomain, EducationLevel> education = new HashMap<>();
        if(tradesman.getEducation() ==  null) {
            tradesman.setEducation(Education.of(new HashMap<>(), new HashMap<>()));
        } else if(tradesman.getEducation().getEducationLevel() == null) {
            tradesman.getEducation().setEducationLevel(new HashMap<>());
        } else {
            education = tradesman.getEducation().getEducationLevel();
        }
        education.put(workDomain, educationLevel);
        tradesman.setEducation(Education.of(education, tradesman.getEducation().getYearExperiences()));
        add(tradesman);

        Map<WorkDomain, EducationLevel> educationDetails = tradesman.getEducation().getEducationLevel();
        educationDetails.put(workDomain, educationLevel);
        tradesman.setEducation(Education.of(educationDetails, tradesman.getEducation().getYearExperiences()));
        add(tradesman);
    }

    @Override
    public void addExperience(TradesmanID tradesmanID, WorkDomain workDomain, Integer experienceYear) {
        Tradesman tradesman = findById(tradesmanID);
        Map<WorkDomain, Integer> experience = new HashMap<>();
        if(tradesman.getEducation() ==  null) {
            tradesman.setEducation(Education.of(new HashMap<>(), new HashMap<>()));
        } else if(tradesman.getEducation().getYearExperiences() == null) {
            tradesman.getEducation().setYearExperiences(new HashMap<>());
        } else {
            experience = tradesman.getEducation().getYearExperiences();
        }
        experience.put(workDomain, experienceYear);
        tradesman.setEducation(Education.of(tradesman.getEducation().getEducationLevel(), experience));
        add(tradesman);
    }

}
