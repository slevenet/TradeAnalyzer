package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ac_points")
public class Points {

    @Id
    @Column(name = "points_id")
    private long id;

    @Column(name = "support_y1")
    private Double supportY1;
    @Column(name = "support_y0")
    private Double supportY0;
    @Column(name = "support_x0")
    private long supportX0;
    @Column(name = "support_x1")
    private long supportX1;
    @Column(name = "resistance_y1")
    private Double resistanceY1;
    @Column(name = "resistance_y0")
    private Double resistanceY0;
    @Column(name = "resistance_x0")
    private long resistanceX0;
    @Column(name = "resistance_x1")
    private long resistanceX1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getSupportY1() {
        return supportY1;
    }

    public void setSupportY1(Double supportY1) {
        this.supportY1 = supportY1;
    }

    public Points() {
    }

    public Points(long id, Double supportY1, Double supportY0, long supportX0, long supportX1, Double resistanceY1, Double resistanceY0, long resistanceX0, long resistanceX1) {
        this.id = id;
        this.supportY1 = supportY1;
        this.supportY0 = supportY0;
        this.supportX0 = supportX0;
        this.supportX1 = supportX1;
        this.resistanceY1 = resistanceY1;
        this.resistanceY0 = resistanceY0;
        this.resistanceX0 = resistanceX0;
        this.resistanceX1 = resistanceX1;
    }

    public Double getSupportY0() {
        return supportY0;
    }

    public void setSupportY0(Double supportY0) {
        this.supportY0 = supportY0;
    }

    public long getSupportX0() {
        return supportX0;
    }

    public void setSupportX0(long supportX0) {
        this.supportX0 = supportX0;
    }

    public long getSupportX1() {
        return supportX1;
    }

    public void setSupportX1(long supportX1) {
        this.supportX1 = supportX1;
    }

    public Double getResistanceY1() {
        return resistanceY1;
    }

    public void setResistanceY1(Double resistanceY1) {
        this.resistanceY1 = resistanceY1;
    }

    public Double getResistanceY0() {
        return resistanceY0;
    }

    public void setResistanceY0(Double resistanceY0) {
        this.resistanceY0 = resistanceY0;
    }

    public long getResistanceX0() {
        return resistanceX0;
    }

    public void setResistanceX0(long resistanceX0) {
        this.resistanceX0 = resistanceX0;
    }

    public long getResistanceX1() {
        return resistanceX1;
    }

    public void setResistanceX1(long resistanceX1) {
        this.resistanceX1 = resistanceX1;
    }

}
