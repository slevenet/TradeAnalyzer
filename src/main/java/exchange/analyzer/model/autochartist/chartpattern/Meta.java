package exchange.analyzer.model.autochartist.chartpattern;

import java.io.Serializable;

public class Meta implements Serializable{

    private Scores scores;
    private Double probability;

    private int interval;
    private int direction;
    private int length;

    private String pattern;
    private String trendtype;

    private Historicalstats historicalstats;
    private boolean completed;

    public Meta() {
    }

    public Meta(Scores scores,
                Double probability,
                int interval,
                int direction,
                int length,
                String pattern,
                String trendtype,
                Historicalstats historicalstats,
                boolean completed) {
        this.scores = scores;
        this.probability = probability;
        this.interval = interval;
        this.direction = direction;
        this.length = length;
        this.pattern = pattern;
        this.trendtype = trendtype;
        this.historicalstats = historicalstats;
        this.completed = completed;
    }

    public Scores getScores() {
        return scores;
    }

    public Double getProbability() {
        return probability;
    }

    public int getInterval() {
        return interval;
    }

    public int getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }

    public String getPattern() {
        return pattern;
    }

    public String getTrendtype() {
        return trendtype;
    }

    public Historicalstats getHistoricalstats() {
        return historicalstats;
    }

    public boolean isCompleted() {
        return completed;
    }
}
