package exchange.analyzer.model.autochartist.chartpattern;

public class Scores {

    private int clarity;
    private int initialtrend;
    private int breakout;
    private int quality;
    private int uniformity;

    public Scores() {
    }

    public Scores(int clarity, int initialtrend, int breakout, int quality, int uniformity) {
        this.clarity = clarity;
        this.initialtrend = initialtrend;
        this.breakout = breakout;
        this.quality = quality;
        this.uniformity = uniformity;
    }

    public int getClarity() {
        return clarity;
    }

    public int getInitialtrend() {
        return initialtrend;
    }

    public int getBreakout() {
        return breakout;
    }

    public int getQuality() {
        return quality;
    }

    public int getUniformity() {
        return uniformity;
    }
}
