package exchange.analyzer;

import exchange.analyzer.entity.CandlePatterns;

import javax.persistence.PostPersist;

public class CandlePatternsListner {

    @PostPersist
    public void findPatterns(CandlePatterns c){

    }
}
