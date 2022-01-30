package org.esgi.trademe.tradesman.domain;

import java.util.Map;
import java.util.Objects;

public final class Education {

    private Map<WorkDomain, EducationLevel> educationLevel;
    private Map<WorkDomain, Integer> yearExperiences;

    private Education(Map<WorkDomain, EducationLevel> educationLevel, Map<WorkDomain, Integer> yearExperiences) {
        this.educationLevel = educationLevel;
        this.yearExperiences = yearExperiences;
    }

    public static Education of(Map<WorkDomain, EducationLevel> educationLevel, Map<WorkDomain, Integer> yearExperiences) {
        return new Education(educationLevel, yearExperiences);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(educationLevel, education.educationLevel) && Objects.equals(yearExperiences, education.yearExperiences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationLevel, yearExperiences);
    }

    @Override
    public String toString() {
        return "Education{" +
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

    public void setEducationLevel(Map<WorkDomain, EducationLevel> educationLevel) {
        this.educationLevel = educationLevel;
    }

    public void setYearExperiences(Map<WorkDomain, Integer> yearExperiences) {
        this.yearExperiences = yearExperiences;
    }
}
