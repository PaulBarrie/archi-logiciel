package org.esgi.trademe.kernel.validator;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

public interface Validator<T> {
    public void isValid(T entity) throws InvalidEntryException;
}
