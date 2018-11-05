package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.*;

@Entity
@Table(name = "ac_data")
public class Data{

    @Id
    @Column(name = "data_id")
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="prediction_id")
    private Prediction prediction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="points_id")
    private Points points;

    private long        patternendtime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public long getPatternendtime() {
        return patternendtime;
    }

    public void setPatternendtime(long patternendtime) {
        this.patternendtime = patternendtime;
    }
}
