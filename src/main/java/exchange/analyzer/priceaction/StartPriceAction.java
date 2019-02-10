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
        System.out.println(candles.get(0).getTf());
        System.out.println(candles.get(0).getCandleType());
        System.out.println(candles.get(0).getInstrument());
        classifiers.stream().map(c -> c.is(candles));
    }
}
