package org.esgi.trademe.project.domain;


import org.esgi.trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class ProjectID implements ValueObjectID {
    private final int value;

    private ProjectID(int value) {
        this.value = value;
    }

    public static ProjectID of(int value) {
        return new ProjectID(value);
    }
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectID contractID = (ProjectID) o;
        return value == contractID.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ContractID{" +
                "value=" + value +
                '}';
    }
}
