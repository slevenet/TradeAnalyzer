package exchange.analyzer.model.autochartist;

import java.io.Serializable;

public class Data implements Serializable{

    private Prediction  prediction;
    private Points      points;
    private long        patternendtime;

    public Data() {
    }

    public Data(Prediction prediction, Points points, long patternendtime) {
        this.prediction = prediction;
        this.points = points;
        this.patternendtime = patternendtime;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public Points getPoints() {
        return points;
    }

    public long getPatternendtime() {
        return patternendtime;
    }
}
