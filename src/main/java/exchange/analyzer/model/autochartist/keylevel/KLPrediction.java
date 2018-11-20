package exchange.analyzer.model.autochartist.keylevel;

import exchange.analyzer.model.autochartist.Prediction;

public class KLPrediction extends Prediction {

	private int timebars;

	public KLPrediction() {}

	public KLPrediction(Double pricelow,
						Double pricehigh,
						long timefrom,
						long timeto,
						int timebars) {
		super(pricelow, pricehigh, timefrom, timeto);
		this.timebars = timebars;
	}

	public int getTimebars() {
		return timebars;
	}

	public void setTimebars(int timebars) {
		this.timebars = timebars;
	}
}
