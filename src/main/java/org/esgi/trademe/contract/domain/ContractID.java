package org.esgi.trademe.contract.domain;


import org.esgi.trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class ContractID implements ValueObjectID {
    private final int value;

    private ContractID(int value) {
        this.value = value;
    }

    public static ContractID of(int value) {
        return new ContractID(value);
    }
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractID tradesmanID = (ContractID) o;
        return value == tradesmanID.value;
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
