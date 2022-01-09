package org.esgi.trademe.kernel.exceptions;

public  final class PaymentRejectedException extends RuntimeException {
    public PaymentRejectedException(String message) {
        super(message);
    }

}
