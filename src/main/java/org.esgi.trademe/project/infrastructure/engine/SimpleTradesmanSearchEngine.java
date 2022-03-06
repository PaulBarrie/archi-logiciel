package org.esgi.trademe.project.infrastructure.engine;

import org.esgi.trademe.tradesman.domain.Tradesman;

import java.util.List;

public class SimpleTradesmanSearchEngine implements TradesmanMatchEngine<SimpleMatchCriterions> {
    
    private final List<Tradesman> tradesmen;

    private SimpleTradesmanSearchEngine(List<Tradesman> tradesmen) {
        this.tradesmen = tradesmen;
    }
    
    public static SimpleTradesmanSearchEngine of(List<Tradesman> tradesmen) {
        return new SimpleTradesmanSearchEngine(tradesmen);
    }
    @Override
    public Tradesman search(SimpleMatchCriterions searchFields) {
        return tradesmen.get(0);
    }
}
