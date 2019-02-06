package exchange.analyzer.priceaction;

import exchange.analyzer.model.Candle;
import exchange.analyzer.priceaction.classifier.Classifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartPriceAction {

    @Autowired
    List<Classifier> classifiers;
    public void process(List<Candle> candles){
        classifiers.stream().map(c -> c.is(candles));
    }
}
