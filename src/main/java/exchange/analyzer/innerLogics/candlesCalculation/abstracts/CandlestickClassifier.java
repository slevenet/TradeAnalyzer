package exchange.analyzer.innerLogics.candlesCalculation.abstracts;


import com.oanda.v20.instrument.Candlestick;

public abstract class CandlestickClassifier {
    private CandlestickClassifier next;

    public CandlestickClassifier linkWith(CandlestickClassifier next) {
        this.next = next;
        return next;
    }

    public abstract String check(Candlestick candlestick);


    public String checkNext(Candlestick candlestick) {
        if (next == null) {
            return "None";
        }
        return next.check(candlestick);
    }
}
