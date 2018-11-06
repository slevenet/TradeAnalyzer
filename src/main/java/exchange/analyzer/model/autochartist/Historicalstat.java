package exchange.analyzer.model.autochartist;

import java.io.Serializable;

public class Historicalstat implements Serializable{

    private Double correct;
    private Double percent;
    private Double total;

    public Historicalstat() {
    }

    public Historicalstat(Double correct, Double percent, Double total) {
        this.correct = correct;
        this.percent = percent;
        this.total = total;
    }

    public Double getCorrect() {
        return correct;
    }

    public Double getPercent() {
        return percent;
    }

    public Double getTotal() {
        return total;
    }
}
