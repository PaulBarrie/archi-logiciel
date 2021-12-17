package org.esgi.trademe.payment.domain;


import org.esgi.trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class PaymentID implements ValueObjectID {
    private final int value;

    public PaymentID(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentID memberID = (PaymentID) o;
        return value == memberID.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PaymentId{" +
                "value=" + value +
                '}';
    }
}
