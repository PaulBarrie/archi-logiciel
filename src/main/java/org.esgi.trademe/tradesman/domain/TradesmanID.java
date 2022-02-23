package org.esgi.trademe.tradesman.domain;


import org.esgi.trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class TradesmanID implements ValueObjectID {
    private final int value;

    private TradesmanID(int value) {
        this.value = value;
    }

    public static TradesmanID of(int value) {
        return new TradesmanID(value);
    }
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesmanID tradesmanID = (TradesmanID) o;
        return value == tradesmanID.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TradesmanID{" +
                "value=" + value +
                '}';
    }
}
