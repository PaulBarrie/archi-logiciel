package org.esgi.trademe.contractor.validation;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.kernel.Handler;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;



public abstract class ContractorHandler implements Handler<Contractor> {
    private ContractorHandler next;

    @Override
    public abstract void check(Contractor member) throws InvalidEntryException;

    @Override
    public Handler<Contractor> setNext(Handler<Contractor> next) {
        this.next = (ContractorHandler) next;
        return next;
    }

    @Override
    public void checkNext(Contractor member) throws InvalidEntryException {
        if (next != null) {
            next.check(member);
        }
    }
}
