package exchange.analyzer.innerLogics.calculations.candlestick.abstracts;


import com.oanda.v20.instrument.Candlestick;
import exchange.analyzer.innerLogics.calculations.candlestick.Classifications;

public abstract class CandlestickClassifier {

    private CandlestickClassifier next;

    public CandlestickClassifier linkWith(CandlestickClassifier next) {
        this.next = next;
        return next;
    }

    public abstract String check(Candlestick candlestick);

    public String checkNext(Candlestick candlestick) {
        if (next == null)
            return Classifications.NONE;

        return next == null ? Classifications.NONE : next.check(candlestick);
    }
}
