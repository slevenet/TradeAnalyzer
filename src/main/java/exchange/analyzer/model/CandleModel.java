package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;



public class CandleModel {

    private String instrument;
    private String tf;

    private String timestamp;


    private double low;
    private double high;
    private double open;
    private double close;

    public CandleModel(Candlestick candelOanda){
        setTf(candelOanda.getTime().toString());
        setClose(candelOanda.getMid().getC().doubleValue());
        setOpen(candelOanda.getMid().getO().doubleValue());
        setHigh(candelOanda.getMid().getH().doubleValue());
        setLow(candelOanda.getMid().getL().doubleValue());
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }


    public void setClose(double close) {
        this.close = close;
    }

    public double getClose() {
        return close;
    }


    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }
}
