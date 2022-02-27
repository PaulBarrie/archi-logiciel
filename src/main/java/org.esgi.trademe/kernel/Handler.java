package org.esgi.trademe.kernel;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

public interface Handler<T> {
    Handler<T> setNext(Handler<T> next);
    void check(T request) throws InvalidEntryException;
    void checkNext(T request) throws InvalidEntryException;
}
