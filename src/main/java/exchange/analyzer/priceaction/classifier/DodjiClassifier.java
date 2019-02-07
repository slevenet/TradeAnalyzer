package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;
import org.springframework.stereotype.Component;


import java.util.List;

import static java.lang.StrictMath.abs;

@Component
public class DodjiClassifier implements Classifier{
    @Override
    public boolean is(List<Candle> candles) {
       // candles.get(candles.size()).getClose()
        // candles.get(candles.size() - 1).getClose()
        return false;
    }

    private boolean isDodjiBody(Candle candle){
        if(abs(candle.getClose() - candle.getOpen()) <= 5)
            return true;
        return false;
    }

    private boolean isDodjiShadow(Candle candle){
        double shadowLow = candle.getOpen() - candle.getLow();
        double shadowHight = candle.getOpen() - candle.getHight();

        if(abs(shadowLow - shadowHight) <= 7)
            return true;
        return false;
    }
}
