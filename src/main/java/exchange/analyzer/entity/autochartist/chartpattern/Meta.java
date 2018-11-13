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

    @Column(name = "`interval`")
    private int interval;
    private int direction;
    private int lenght;

    private String pattern;
    private String trendtype;

    private boolean completed;

    public Meta() {
    }

    public Meta(long id, Scores scores, Double probability, int interval, int direction, int lenght, String pattern, String trendtype, boolean completed) {
        this.id = id;
        this.scores = scores;
        this.probability = probability;
        this.interval = interval;
        this.direction = direction;
        this.lenght = lenght;
        this.pattern = pattern;
        this.trendtype = trendtype;
        this.completed = completed;
    }

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
        return lenght;
    }

    public void setLength(int lenght) {
        this.lenght = lenght;
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

