package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;

import java.util.List;

public interface Classifier {
    boolean is(List<Candle> candles);
}
