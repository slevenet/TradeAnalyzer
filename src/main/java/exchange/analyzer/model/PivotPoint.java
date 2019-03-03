package exchange.analyzer.model;

public class PivotPoint {
    private double pivotPoint;
    private double s1;
    private double s2;
    private double s3;
    private double r1;
    private double r2;
    private double r3;
    private String tf;
    private String instrument;

    public PivotPoint() {
    }

    public PivotPoint(Candle candle) {
        double pivot = (candle.getHigh() + candle.getLow() + candle.getClose()) / 3;
        this.pivotPoint = pivot;
        this.s1 = 2 * pivot - candle.getHigh();
        this.s2 = pivot - ((2 * pivot - candle.getLow()) - (2 * pivot - candle.getHigh()));
        this.s3 = candle.getLow() - 2 * (candle.getHigh() - pivot);
        this.r1 = 2 * pivot - candle.getLow();
        this.r2 = pivot + ((2 * pivot - candle.getLow()) - (2 * pivot - candle.getHigh()));
        this.r3 = candle.getHigh() + 2 * (pivot - candle.getLow());
        this.tf = candle.getTf();
        this.instrument = candle.getInstrument();
    }

    public double getPivotPoint() {
        return pivotPoint;
    }

    public void setPivotPoint(double pivotPoint) {
        this.pivotPoint = pivotPoint;
    }

    public double getS1() {
        return s1;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }

    public double getS2() {
        return s2;
    }

    public void setS2(double s2) {
        this.s2 = s2;
    }

    public double getS3() {
        return s3;
    }

    public void setS3(double s3) {
        this.s3 = s3;
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public double getR3() {
        return r3;
    }

    public void setR3(double r3) {
        this.r3 = r3;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "PivotPoint{" +
                "pivotPoint=" + pivotPoint +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", r1=" + r1 +
                ", r2=" + r2 +
                ", r3=" + r3 +
                ", tf='" + tf + '\'' +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
