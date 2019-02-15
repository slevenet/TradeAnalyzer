package exchange.analyzer.model;

import java.util.Comparator;

public class CandleComporator implements Comparator<Candle> {
    @Override
    public int compare(Candle o1, Candle o2) {
        return o1.getTimestamp().compareTo(o2.getTimestamp());
    }
}
