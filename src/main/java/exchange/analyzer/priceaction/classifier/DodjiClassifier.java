package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;
import org.springframework.stereotype.Component;


import java.util.List;

import static java.lang.StrictMath.abs;


//body is not more 10p
//shadow: or each of the shadows are more body * 2, or one of it is more body * 3
@Component
public class DodjiClassifier implements Classifier{
    @Override
    public void is(List<Candle> candles) {
        if (isDodjiBody(candles.get(0)) && isDodjiShadow(candles.get(0)))
            System.out.println("Dodji - " + candles.get(0).getTf() + candles.get(0).getInstrument());

    }

    private boolean isDodjiBody(Candle candle){
        if(candle.getBodySize() <= 10)
            return true;
        return false;
    }

    private boolean isDodjiShadow(Candle candle){
        if ((candle.getLowShadow() >= (candle.getBodySize() * 3)) ||
                (candle.getTopShadow() >= (candle.getBodySize() * 3)))
            return true;
        if ((candle.getLowShadow() >= (candle.getBodySize() * 2)) &&
                (candle.getTopShadow() >= (candle.getBodySize() * 2)))
            return true;
        return false;
    }
}
