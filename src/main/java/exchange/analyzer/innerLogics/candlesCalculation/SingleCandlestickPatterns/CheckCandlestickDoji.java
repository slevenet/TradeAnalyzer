package exchange.analyzer.innerLogics.candlesCalculation.SingleCandlestickPattens;

import com.oanda.v20.instrument.Candlestick;
import exchange.analyzer.innerLogics.candlesCalculation.abstracts.CandlestickClassifier;
import org.springframework.stereotype.Component;

@Component
public class CheckCandlestickDoji extends CandlestickClassifier {
    @Override
    public String check(Candlestick candlestick) {
         if(candlestick.toString() == "Doji")
            return "Doji";

        return checkNext(candlestick);
    }
}
