package org.esgi.trademe.kernel.exceptions;

public final class AlreadyUsedParameterException extends InvalidParameterException {

    public AlreadyUsedParameterException(String message) {
        super(message);
    }

    public static AlreadyUsedParameterException with(String field, String value) {
        return new AlreadyUsedParameterException(String.format("%s %s is already used", field, value));
    }
}
