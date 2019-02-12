package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;

import java.util.List;
import java.util.TreeSet;

public interface Classifier {
    void is(TreeSet<Candle> candles);
}
