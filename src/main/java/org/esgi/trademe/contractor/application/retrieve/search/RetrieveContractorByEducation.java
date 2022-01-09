package org.esgi.trademe.contractor.application.retrieve.search;


import org.esgi.trademe.contractor.domain.WorkDomain;
import org.esgi.trademe.kernel.query.Query;

import java.util.List;

public final class RetrieveContractorByEducation implements Query {
    private final List<WorkDomain> domains;

    public RetrieveContractorByEducation(List<WorkDomain> domains) {
        this.domains = domains;
    }

    public List<WorkDomain> getDomains() {
        return domains;
    }
}
