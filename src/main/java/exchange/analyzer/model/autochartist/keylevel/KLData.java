package exchange.analyzer.model.autochartist.keylevel;

import exchange.analyzer.model.autochartist.chartpattern.Data;
import exchange.analyzer.model.autochartist.chartpattern.Points;
import exchange.analyzer.model.autochartist.chartpattern.Prediction;

public class KLData extends Data<KeyLevelPrediction, > {

	private Double price;

	public KLData() {}

	public KLData(Prediction prediction,
				  Points points,
				  long patternendtime,
				  Double price) {
		super(prediction, points, patternendtime);
		this.price = price;
	}
}
