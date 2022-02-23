package org.esgi.trademe.kernel.command;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.security.NoSuchAlgorithmException;

public interface CommandHandler<C extends Command, R> {
    R handle(C command) throws NoSuchAlgorithmException, InvalidEntryException;
}
