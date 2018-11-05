package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ac_prediction")
public class Prediction {

    private Double  pricelow;
    private Double  pricehigh;
    private long    timefrom;
    private long    timeto;


    public Double getPricelow() {
        return pricelow;
    }

    public void setPricelow(Double pricelow) {
        this.pricelow = pricelow;
    }

    public Double getPricehigh() {
        return pricehigh;
    }

    public void setPricehigh(Double pricehigh) {
        this.pricehigh = pricehigh;
    }

    public long getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(long timefrom) {
        this.timefrom = timefrom;
    }

    public long getTimeto() {
        return timeto;
    }

    public void setTimeto(long timeto) {
        this.timeto = timeto;
    }
}
