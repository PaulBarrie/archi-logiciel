package org.esgi.trademe.payment.domain;



import org.esgi.trademe.kernel.Entity;
import org.esgi.trademe.member.domain.MemberID;

import java.util.Objects;

public final class Payment implements Entity<PaymentID> {
    private final PaymentID id;
    private final MemberID memberID;
    private final PaymentMode paymentMode;

    private Payment(PaymentID id, MemberID memberID, PaymentMode paymentMode) {
        this.id = id;
        this.memberID = memberID;
        this.paymentMode = paymentMode;
    }

    public static Payment of(PaymentID id, MemberID memberID, PaymentMode paymentMode) {
        return new Payment(id, memberID, paymentMode);
    }


    @Override
    public PaymentID id() {
        return id;
    }

    public PaymentID getId() {
        return id;
    }

    public MemberID getMemberID() {
        return memberID;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(memberID, payment.getMemberID())  &&
                Objects.equals(paymentMode, payment.getPaymentMode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", memberID='" + memberID + '\'' +
                ", payment='" + paymentMode + '\'' +
                '}';
    }
}
