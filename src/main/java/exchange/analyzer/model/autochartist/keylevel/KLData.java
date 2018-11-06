package exchange.analyzer.model.autochartist.keylevel;

import exchange.analyzer.model.autochartist.Data;

public class KLData extends Data<KLPrediction, KLPoints> {

	private Double price;

	public KLData() {}

	public KLData(KLPrediction prediction,
				  KLPoints points,
				  long patternendtime,
				  Double price) {
		super(prediction, points, patternendtime);
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
