package exchange.analyzer.entity;

import javax.persistence.*;

@Entity
@Table(name = "pivotpoints")
public class PivotPointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instrument;
    private String tf;
    private double r1;
    private double s1;
    private double r2;
    private double s2;
    private double r3;
    private double s3;
    private double pivotpoint;

    public PivotPointEntity() {
    }

    public PivotPointEntity(String instrument,
                            String tf,
                            double r1,
                            double s1,
                            double r2,
                            double s2,
                            double r3,
                            double s3,
                            double pivotpoint) {
        this.instrument = instrument;
        this.tf = tf;
        this.r1 = r1;
        this.s1 = s1;
        this.r2 = r2;
        this.s2 = s2;
        this.r3 = r3;
        this.s3 = s3;
        this.pivotpoint = pivotpoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getS1() {
        return s1;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public double getS2() {
        return s2;
    }

    public void setS2(double s2) {
        this.s2 = s2;
    }

    public double getR3() {
        return r3;
    }

    public void setR3(double r3) {
        this.r3 = r3;
    }

    public double getS3() {
        return s3;
    }

    public void setS3(double s3) {
        this.s3 = s3;
    }

    public double getPivotpoint() {
        return pivotpoint;
    }

    public void setPivotpoint(double pivotpoint) {
        this.pivotpoint = pivotpoint;
    }
}
