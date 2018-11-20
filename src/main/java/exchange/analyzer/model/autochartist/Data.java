package exchange.analyzer.model.autochartist;

import java.io.Serializable;

public class Data<T extends Prediction, P extends AbstractPoints> implements Serializable{

    private T       prediction;
    private P       points;
    private long    patternendtime;

    public Data() {}

    public Data(T prediction,
                P points,
                long patternendtime) {
        this.prediction = prediction;
        this.points = points;
        this.patternendtime = patternendtime;
    }

    public T getPrediction() {
        return prediction;
    }

    public P getPoints() {
        return points;
    }

    public long getPatternendtime() {
        return patternendtime;
    }
}
