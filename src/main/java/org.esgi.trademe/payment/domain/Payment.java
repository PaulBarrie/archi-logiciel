package org.esgi.trademe.payment.domain;



import org.esgi.trademe.kernel.Entity;
import org.esgi.trademe.contractor.domain.ContractorID;

import java.util.Objects;

public final class Payment implements Entity<PaymentID> {
    private final PaymentID id;
    private final ContractorID contractorID;
    private final PaymentMode paymentMode;

    private Payment(PaymentID id, ContractorID contractorID, PaymentMode paymentMode) {
        this.id = id;
        this.contractorID = contractorID;
        this.paymentMode = paymentMode;
    }

    public static Payment of(PaymentID id, ContractorID contractorID, PaymentMode paymentMode) {
        return new Payment(id, contractorID, paymentMode);
    }


    @Override
    public PaymentID id() {
        return id;
    }

    public PaymentID getId() {
        return id;
    }

    public ContractorID getContractorID() {
        return contractorID;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(contractorID, payment.getContractorID())  &&
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
                ", contractorID='" + contractorID + '\'' +
                ", payment='" + paymentMode + '\'' +
                '}';
    }
}
