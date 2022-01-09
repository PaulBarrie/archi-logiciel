package org.esgi.trademe.kernel.exceptions;

public final class InvalidChoiceException extends IllegalArgumentException {
    public InvalidChoiceException(String message) {super(message);}

    public static InvalidChoiceException withEnum(Class<? extends Enum> enumType, String constantName) {
        return new InvalidChoiceException(String.format("%s is not a valid choice for %s", constantName, enumType));
    }
}
