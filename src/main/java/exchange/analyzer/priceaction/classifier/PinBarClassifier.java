package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TreeSet;

@Component
public class PinBarClassifier implements Classifier {
	@Override
	public void is(TreeSet<Candle> candles) {
		Candle candle = candles.last();

			double high = candle.getHigh();
			double low = candle.getLow();
			double open = candle.getOpen();
			double close = candle.getClose();

			if (isPinBar(high, low, open, close))
				; // save into db


		// save into db false
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
