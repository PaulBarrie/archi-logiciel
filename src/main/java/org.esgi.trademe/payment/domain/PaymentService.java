package org.esgi.trademe.payment.domain;

public interface PaymentService {
    boolean pay(PaymentMode fromPayment, PaymentMode toPayment, Float amount);
}
