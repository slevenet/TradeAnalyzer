package exchange.analyzer.model.autochartist.keylevel;

import exchange.analyzer.model.autochartist.chartpattern.Prediction;

public class KeyLevelPrediction extends Prediction {

	private int timebars;

	public KeyLevelPrediction() {}

	public KeyLevelPrediction(Double pricelow,
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
