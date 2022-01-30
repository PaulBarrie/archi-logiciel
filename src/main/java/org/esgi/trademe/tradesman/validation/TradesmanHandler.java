package org.esgi.trademe.tradesman.validation;


import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.kernel.Handler;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;



public abstract class TradesmanHandler implements Handler<Tradesman> {
    private TradesmanHandler next;

    @Override
    public abstract void check(Tradesman contractor) throws InvalidEntryException;

    @Override
    public Handler<Tradesman> setNext(Handler<Tradesman> next) {
        this.next = (TradesmanHandler) next;
        return next;
    }

    @Override
    public void checkNext(Tradesman contractor) throws InvalidEntryException {
        if (next != null) {
            next.check(contractor);
        }
    }
}
