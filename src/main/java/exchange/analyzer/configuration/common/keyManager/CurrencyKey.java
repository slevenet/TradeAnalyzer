package exchange.analyzer.configuration.common.keyManager;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.InstrumentName;

public class CurrencyKey {

    private InstrumentName currency;
    private CandlestickGranularity granularity;

    CurrencyKey(InstrumentName currency, CandlestickGranularity granularity) {
        this.currency = currency;
        this.granularity = granularity;
    }

    public String getKey(){
        return currency + "_" + granularity;
    }

    public InstrumentName getCurrency() {
        return currency;
    }

    public CandlestickGranularity getGranularity() {
        return granularity;
    }
}
