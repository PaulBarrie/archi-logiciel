package org.esgi.trademe.payment.application.update;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.payment.domain.PaymentMode;


/**
 * Command object
 */
@SuppressWarnings("all")
public final class UsePayment implements Command {
    private final PaymentMode fromPayment;
    private final PaymentMode toPayment;
    private final Float amount;

    public UsePayment(PaymentMode fromPayment, PaymentMode toPayment, Float amount) {
        this.fromPayment = fromPayment;
        this.toPayment = toPayment;
        this.amount = amount;
    }

    public static UsePayment of(PaymentMode fromPayment, PaymentMode toPayment, Float amount) {
        return new UsePayment(fromPayment, toPayment, amount);
    }

    public PaymentMode getFromPayment() {
        return fromPayment;
    }

    public PaymentMode getToPayment() {
        return toPayment;
    }

    public Float getAmount() {
        return amount;
    }
}
