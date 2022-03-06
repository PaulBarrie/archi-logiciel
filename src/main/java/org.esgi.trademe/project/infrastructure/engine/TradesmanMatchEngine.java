package org.esgi.trademe.project.infrastructure.engine;

import org.esgi.trademe.tradesman.domain.Tradesman;

public interface TradesmanMatchEngine<T extends MatchCriterions> {
    public Tradesman search(T searchFields);
}
