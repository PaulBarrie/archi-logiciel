package org.esgi.trademe.contractor.domain;

public enum EducationLevel {
    BEP("bep"),
    BAC("bac"),
    BTS("bts");
    private String level;
    EducationLevel(String level) {
        this.level = level;
    }
}
