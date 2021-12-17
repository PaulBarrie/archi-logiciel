package org.esgi.trademe.payment.infrastructure;

import org.esgi.trademe.payment.domain.Payment;
import org.esgi.trademe.payment.domain.PaymentMode;
import org.esgi.trademe.payment.domain.PaymentService;

public class StubbedPaymentService implements PaymentService {
    @Override
    public boolean pay(PaymentMode fromPayment, PaymentMode toPayment, Float amount) {
        return true;
    }
}
