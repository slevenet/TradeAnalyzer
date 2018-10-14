package exchange.analyzer.innerLogics.candlestickCalculation;

import com.oanda.v20.instrument.Candlestick;
import exchange.analyzer.innerLogics.candlestickCalculation.abstracts.CandlestickClassifier;
import org.springframework.stereotype.Component;

@Component
public class CheckCandelstickDoji extends CandlestickClassifier {
    @Override
    public String check(Candlestick candlestick) {
        if(candlestick.toString() == "Doji")
        return "Dodji";
        return checkNext(candlestick);
    }

}
