package org.esgi.trademe.kernel.command;

import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public final class SimpleCommandBus implements CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> dataMap;

    public SimpleCommandBus(Map<Class<? extends Command>, CommandHandler> dataMap) {
        this.dataMap = dataMap;
    }

    @Override
    public <R, C extends Command> R send(C command) throws InvalidEntryException, NoSuchAlgorithmException {
        final CommandHandler commandHandler = dataMap.get(command.getClass());
        if(commandHandler == null)  {
            throw new RuntimeException("No such command handler for " + command.getClass().getName());
        }
        return (R) commandHandler.handle(command);
    }
}
