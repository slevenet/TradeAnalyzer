package exchange.analyzer.model.charts;

public class ChartPatternModel {

    protected Double  pricelow;
    protected Double  pricehigh;
    protected long    timefrom;
    protected long    timeto;

    private Double y1;
    private Double y0;

    private long x0;
    private long x1;

    private long    patternendtime;

    private int interval;
    private int direction;
    private int length;

    private String pattern;
    private String trendtype;

    public Double getPricelow() {
        return pricelow;
    }

    public void setPricelow(Double pricelow) {
        this.pricelow = pricelow;
    }

    public Double getPricehigh() {
        return pricehigh;
    }

    public void setPricehigh(Double pricehigh) {
        this.pricehigh = pricehigh;
    }

    public long getTimefrom() {
        return timefrom;
    }

    public void setTimefrom(long timefrom) {
        this.timefrom = timefrom;
    }

    public long getTimeto() {
        return timeto;
    }

    public void setTimeto(long timeto) {
        this.timeto = timeto;
    }

    public Double getY1() {
        return y1;
    }

    public void setY1(Double y1) {
        this.y1 = y1;
    }

    public Double getY0() {
        return y0;
    }

    public void setY0(Double y0) {
        this.y0 = y0;
    }

    public long getX0() {
        return x0;
    }

    public void setX0(long x0) {
        this.x0 = x0;
    }

    public long getX1() {
        return x1;
    }

    public void setX1(long x1) {
        this.x1 = x1;
    }

    public long getPatternendtime() {
        return patternendtime;
    }

    public void setPatternendtime(long patternendtime) {
        this.patternendtime = patternendtime;
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
}
