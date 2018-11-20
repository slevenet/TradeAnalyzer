package exchange.analyzer.model.autochartist.chartpattern;

public class ChartPatternPoint extends AbstractPoint {

	private Double y1;
	private Double y0;

	private long x0;
	private long x1;

	public ChartPatternPoint() {}

	public ChartPatternPoint(Double y1,
							 Double y0,
							 long x0,
							 long x1) {
		this.y1 = y1;
		this.y0 = y0;
		this.x0 = x0;
		this.x1 = x1;
	}

	public Double getY1() {
		return y1;
	}

	public Double getY0() {
		return y0;
	}

	public long getX0() {
		return x0;
	}

	public long getX1() {
		return x1;
	}
}
