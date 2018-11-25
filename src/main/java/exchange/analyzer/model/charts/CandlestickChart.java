package exchange.analyzer.model.charts;

import com.oanda.v20.instrument.Candlestick;
import exchange.analyzer.configuration.common.keyManager.CurrencyKey;
import java.util.List;


public class CandlestickChart {

    private CurrencyKey key;
    private  List<Candlestick> value;

    public CandlestickChart() {
    }

    public CandlestickChart(CurrencyKey key, List<Candlestick> value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(CurrencyKey key) {
        this.key = key;
    }

    public void setValue(List<Candlestick> value) {
        this.value = value;
    }

    public CurrencyKey getKey() {
        return key;
    }

    public List<Candlestick> getValue() {
        return value;
    }


}