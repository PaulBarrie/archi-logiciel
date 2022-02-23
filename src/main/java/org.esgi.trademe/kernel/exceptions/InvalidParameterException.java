package org.esgi.trademe.kernel.exceptions;

public class InvalidParameterException extends IllegalArgumentException {
    public InvalidParameterException(String message) {super(message);}

    public static InvalidParameterException withStringInteger(String value) {
        return new InvalidParameterException(String.format("%s is not a valid integer", value));
    }

    public static InvalidParameterException forField(String field, String value) {
        return new InvalidParameterException(String.format("%s is not a valid value for field %s", value, field));
    }
}
