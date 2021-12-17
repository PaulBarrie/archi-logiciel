package org.esgi.trademe.contractor.application.retrieve.search;


import org.esgi.trademe.contractor.domain.ContractorID;
import org.esgi.trademe.contractor.domain.WorkDomain;
import org.esgi.trademe.kernel.event.ApplicationEvent;

import java.util.List;

public class RetrieveContractorByEducationEvent implements ApplicationEvent {
    private final List<WorkDomain> domain;

    public RetrieveContractorByEducationEvent(List<WorkDomain> domain) {
        this.domain = domain;
    }

    public static RetrieveContractorByEducationEvent of(List<WorkDomain> domain) {
        return new RetrieveContractorByEducationEvent(domain);
    }
}
