package org.esgi.trademe.payment.application.retrieve;


import org.esgi.trademe.kernel.query.Query;

import org.esgi.trademe.payment.domain.PaymentID;

public final class RetrievePayment implements Query {
    private final PaymentID paymentID;


    public RetrievePayment(PaymentID paymentID) {
        this.paymentID = paymentID;
    }

    public PaymentID getPaymentID() {
        return paymentID;
    }
}
