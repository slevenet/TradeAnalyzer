package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;

import java.util.List;

public class PinBarClassifier implements Classifier {
	@Override
	public boolean is(List<Candle> candles) {
		for (Candle candle : candles)
		{
			double high = candle.getHigh();
			double low = candle.getLow();
			double open = candle.getOpen();
			double close = candle.getClose();

			if (isPinBar(high, low, open, close))
				return true;
		}

		return false;
	}

	private boolean isPinBar(double high, double low, double open, double close) {
		if ((high - low) > 2*Math.abs(close - open)) {
			//shooting star
			if ((open - low) < 0.3*(high - low) || (close - low) < 0.3*(high - low))
				return true;

			// hammer
			if ((high - open) < 0.3*(high - low) || (high - close) < 0.3*(high - low))
				return true;
		}

		return false;
	}
}
