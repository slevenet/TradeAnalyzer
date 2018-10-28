package exchange.analyzer.model.autochartist;

import java.io.Serializable;

public class Historicalstats implements Serializable{

    private Historicalstat symbol;
    private Historicalstat pattern;
    private Historicalstat hourofday;

    public Historicalstats() {
    }

    public Historicalstats(Historicalstat symbol, Historicalstat pattern, Historicalstat hourofday) {
        this.symbol = symbol;
        this.pattern = pattern;
        this.hourofday = hourofday;
    }

    public Historicalstat getSymbol() {
        return symbol;
    }

    public Historicalstat getPattern() {
        return pattern;
    }

    public Historicalstat getHourofday() {
        return hourofday;
    }
}
