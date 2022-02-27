package org.esgi.trademe.tradesman.application.retrieve.search;


import org.esgi.trademe.tradesman.domain.WorkDomain;
import org.esgi.trademe.kernel.event.ApplicationEvent;

import java.util.List;

public class RetrieveTradesmanByDomainEvent implements ApplicationEvent {
    private final List<WorkDomain> domain;

    public RetrieveTradesmanByDomainEvent(List<WorkDomain> domain) {
        this.domain = domain;
    }

    public static RetrieveTradesmanByDomainEvent of(List<WorkDomain> domain) {
        return new RetrieveTradesmanByDomainEvent(domain);
    }
}
