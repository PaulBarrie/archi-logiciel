package org.esgi.trademe.kernel.command;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.security.NoSuchAlgorithmException;

public interface CommandBus {
    <R, C extends Command> R send(C command) throws InvalidEntryException, NoSuchAlgorithmException;
}
