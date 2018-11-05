package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.*;

@Entity
@Table(name = "ac_meta")
public class Meta {

    @Id
    @Column(name = "meta_id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scores_id")
    private Scores scores;
    private Double probability;

    private int interval;
    private int direction;
    private int length;

    private String pattern;
    private String trendtype;

    private boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getTrendtype() {
        return trendtype;
    }

    public void setTrendtype(String trendtype) {
        this.trendtype = trendtype;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

