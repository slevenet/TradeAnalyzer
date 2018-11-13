package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ac_prediction")
public class Prediction {

    @Id
    @Column(name = "prediction_id")
    private long    prediction_id;
    private Double  pricelow;
    private Double  pricehigh;
    private long    timefrom;
    private long    timeto;


    public Prediction() {
    }

    public Prediction(long prediction_id, Double pricelow, Double pricehigh, long timefrom, long timeto) {
        this.prediction_id = prediction_id;
        this.pricelow = pricelow;
        this.pricehigh = pricehigh;
        this.timefrom = timefrom;
        this.timeto = timeto;
    }

    public long getPrediction_id() {
        return prediction_id;
    }

    public void setPrediction_id(long prediction_id) {
        this.prediction_id = prediction_id;
    }

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
