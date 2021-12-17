package org.esgi.trademe.kernel.exceptions;

import javax.management.InvalidAttributeValueException;

public class InvalidEntryException extends InvalidAttributeValueException {
    public InvalidEntryException(String message) {super(message);}

    public static InvalidEntryException forField(String field, String value) {
        return new InvalidEntryException(String.format("%s is not a valid value for the field %s", value, field));
    }

    public static InvalidEntryException unprovided(String field) {
        return new InvalidEntryException(String.format("No value has been provided for %s", field));
    }

}
