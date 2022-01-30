package org.esgi.trademe.tradesman.exposition;

import org.esgi.trademe.tradesman.domain.EducationLevel;
import org.esgi.trademe.tradesman.domain.WorkDomain;

import java.util.Map;
import java.util.Objects;

public class EducationDTO {
    private final Map<WorkDomain, EducationLevel> educationLevel;
    private final Map<WorkDomain, Integer> yearExperiences;

    private EducationDTO(Map<WorkDomain, EducationLevel> educationLevel, Map<WorkDomain, Integer> yearExperiences) {
        this.educationLevel = educationLevel;
        this.yearExperiences = yearExperiences;
    }

    public static EducationDTO of(Map<WorkDomain, EducationLevel> educationLevel, Map<WorkDomain, Integer> yearExperiences) {
        return new EducationDTO(educationLevel, yearExperiences);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationDTO education = (EducationDTO) o;
        return Objects.equals(educationLevel, education.educationLevel) && Objects.equals(yearExperiences, education.yearExperiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationLevel, yearExperiences);
    }

    @Override
    public String toString() {
        return "EducationDTO{" +
                "education=" + educationLevel +
                ", experience(year)='" + yearExperiences + '\'' +
                '}';
    }

    public Map<WorkDomain, EducationLevel> getEducationLevel() {
        return educationLevel;
    }

    public Map<WorkDomain, Integer> getYearExperiences() {
        return yearExperiences;
    }
}
