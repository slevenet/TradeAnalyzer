package exchange.analyzer.model.autochartist;

import java.io.Serializable;

public class Prediction implements Serializable{

    private Double  pricelow;
    private Double  pricehigh;
    private long    timefrom;
    private long    timeto;

    public Prediction() {
    }

    public Prediction(Double pricelow, Double pricehigh, long timefrom, long timeto) {
        this.pricelow = pricelow;
        this.pricehigh = pricehigh;
        this.timefrom = timefrom;
        this.timeto = timeto;
    }

    public Double getPricelow() {
        return pricelow;
    }

    public Double getPricehigh() {
        return pricehigh;
    }

    public long getTimefrom() {
        return timefrom;
    }

    public long getTimeto() {
        return timeto;
    }
}
