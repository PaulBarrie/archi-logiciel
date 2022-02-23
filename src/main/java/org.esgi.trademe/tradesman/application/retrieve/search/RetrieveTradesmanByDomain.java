package org.esgi.trademe.tradesman.application.retrieve.search;


import org.esgi.trademe.tradesman.domain.WorkDomain;
import org.esgi.trademe.kernel.query.Query;

import java.util.List;

public final class RetrieveTradesmanByDomain implements Query {
    private final List<WorkDomain> domains;

    public RetrieveTradesmanByDomain(List<WorkDomain> domains) {
        this.domains = domains;
    }

    public List<WorkDomain> getDomains() {
        return domains;
    }
}
