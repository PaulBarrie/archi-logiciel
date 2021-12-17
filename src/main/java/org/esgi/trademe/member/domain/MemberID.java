package org.esgi.trademe.member.domain;


import org.esgi.trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class MemberID implements ValueObjectID {
    private final int value;

    private MemberID(int value) {
        this.value = value;
    }

    public static MemberID of(int value) {
        return new MemberID(value);
    }
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberID memberID = (MemberID) o;
        return value == memberID.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MemberId{" +
                "value=" + value +
                "}";
    }
}
