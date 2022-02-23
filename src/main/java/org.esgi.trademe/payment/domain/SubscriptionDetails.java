package org.esgi.trademe.payment.domain;

public final class SubscriptionDetails {
    private final PaymentMode paymentMode;
    private final Float monthlyAmount;

    public SubscriptionDetails(PaymentMode paymentMode, Float monthlyAmount) {
        this.paymentMode = paymentMode;
        this.monthlyAmount = monthlyAmount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public Float getMonthlyAmount() {
        return monthlyAmount;
    }
}
