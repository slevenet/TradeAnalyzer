package exchange.analyzer.innerLogics.calculations.candlestick.singleCandlestickPatterns;

import com.oanda.v20.instrument.Candlestick;
import exchange.analyzer.innerLogics.calculations.candlestick.Classifications;
import exchange.analyzer.innerLogics.calculations.candlestick.abstracts.CandlestickClassifier;
import org.springframework.stereotype.Component;

@Component
public class CheckCandlestickDoji extends CandlestickClassifier {
    @Override
    public String check(Candlestick candlestick) {
         if(candlestick.toString() == Classifications.DOJI)   // TODO CANDLESTICK PATTERN VERIFICATION
            return Classifications.DOJI;

        return checkNext(candlestick);
    }
}
