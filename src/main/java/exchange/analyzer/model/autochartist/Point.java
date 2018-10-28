package exchange.analyzer.model.autochartist;

public class Point {

    private Double y1;
    private Double y0;
    private long x1;
    private long x2;

    public Point(Double y1, Double y0, long x1, long x2) {
        this.y1 = y1;
        this.y0 = y0;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Double getY1() {
        return y1;
    }

    public Double getY0() {
        return y0;
    }

    public long getX1() {
        return x1;
    }

    public long getX2() {
        return x2;
    }
}
