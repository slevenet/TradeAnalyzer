package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ac_scores")
public class Scores {

    @Id
    @Column(name = "scores_id")
    private long id;

    private int clarity;
    @Column(name = "initial_trend")
    private int initialtrend;
    private int breakout;
    private int quality;
    private int uniformity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClarity() {
        return clarity;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }

    public int getInitialtrend() {
        return initialtrend;
    }

    public void setInitialtrend(int initialtrend) {
        this.initialtrend = initialtrend;
    }

    public int getBreakout() {
        return breakout;
    }

    public Scores() {
    }

    public Scores(long id, int clarity, int initialtrend, int breakout, int quality, int uniformity) {
        this.id = id;
        this.clarity = clarity;
        this.initialtrend = initialtrend;
        this.breakout = breakout;
        this.quality = quality;
        this.uniformity = uniformity;
    }

    public void setBreakout(int breakout) {
        this.breakout = breakout;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getUniformity() {
        return uniformity;
    }

    public void setUniformity(int uniformity) {
        this.uniformity = uniformity;
    }

}
