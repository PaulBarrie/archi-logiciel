package org.esgi.trademe.payment.exposition;


import org.esgi.trademe.payment.domain.Payment;

@SuppressWarnings("all")
public class PaymentDTO {
    public final Payment payment;

    public PaymentDTO(Payment payment) {
        this.payment = payment;
    }


    public static PaymentDTO of(Payment payment){
        return new PaymentDTO(payment);
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + payment.id() +
                ", payment='" + payment.getPaymentMode() + '\'' +
                '}';
    }

    public Payment getPayment() {
        return payment;
    }
}
