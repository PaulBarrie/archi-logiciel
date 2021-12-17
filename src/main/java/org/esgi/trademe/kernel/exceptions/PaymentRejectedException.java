package org.esgi.trademe.kernel.exceptions;

public class PaymentRejectedException extends RuntimeException {
    public PaymentRejectedException(String message) {
        super(message);
    }

}
