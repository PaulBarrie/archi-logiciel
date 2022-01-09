package org.esgi.trademe.project.application.update;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.kernel.event.ApplicationEvent;

public final class AcceptProjectEvent implements ApplicationEvent {
    private final ContractorID memberID;

    public AcceptProjectEvent(ContractorID memberID) {
        this.memberID = memberID;
    }

    public static AcceptProjectEvent of(ContractorID memberID) {
        return new AcceptProjectEvent(memberID);
    }
}
