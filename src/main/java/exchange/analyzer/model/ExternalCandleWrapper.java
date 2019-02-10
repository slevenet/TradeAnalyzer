package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;

import java.util.List;

public class ExternalCandleWrapper {
    private List<Candlestick> candlestick;
    private String tf;
    private String instrument;


    public List<Candlestick> getCandlestick() {
        return candlestick;
    }

    public void setCandlestick(List<Candlestick> candlestick) {
        this.candlestick = candlestick;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
