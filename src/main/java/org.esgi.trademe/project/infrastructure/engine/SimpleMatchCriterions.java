package org.esgi.trademe.project.infrastructure.engine;

import org.esgi.trademe.tradesman.domain.WorkDomain;

public class SimpleMatchCriterions extends MatchCriterions {
    
    public SimpleMatchCriterions() {
    }

    public static SimpleMatchCriterions of() {
        return new SimpleMatchCriterions();
    }
}
