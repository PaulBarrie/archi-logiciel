package org.esgi.trademe.contractor.domain;


import org.esgi.trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class ContractorID implements ValueObjectID {
    private final int value;

    private ContractorID(int value) {
        this.value = value;
    }

    public static ContractorID of(int value) {
        return new ContractorID(value);
    }
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorID contractorID = (ContractorID) o;
        return value == contractorID.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ContractorID{" +
                "value=" + value +
                '}';
    }
}
