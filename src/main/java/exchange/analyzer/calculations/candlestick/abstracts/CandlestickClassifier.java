package exchange.analyzer.calculations.candlestick.abstracts;


import com.oanda.v20.instrument.Candlestick;
import exchange.analyzer.calculations.candlestick.Classifications;

public abstract class CandlestickClassifier {

    private CandlestickClassifier next;

    public CandlestickClassifier linkWith(CandlestickClassifier next) {
        this.next = next;
        return next;
    }

    public abstract String check(Candlestick candlestick);

    public String checkNext(Candlestick candlestick) {

        return next == null ? Classifications.NONE : next.check(candlestick);
    }
}
