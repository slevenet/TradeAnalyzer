package exchange.analyzer.priceaction.classifier;

import exchange.analyzer.model.Candle;
import exchange.analyzer.priceaction.classifier.settings.PinBarSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

import static exchange.analyzer.utils.CandleUtils.getPoints;

@Component
public class PinBarClassifier implements Classifier {

	@Autowired
	private PinBarSettings settings;

	@Override
	public void is(TreeSet<Candle> candles) {
		boolean isPinBar = false;

		Candle candle = candles.last();

		double high = candle.getHigh();
		double low = candle.getLow();
		double open = candle.getOpen();
		double close = candle.getClose();

		isPinBar = isPinBar(high, low, open, close);

		if (settings.isIncludeCustomSettings())
			isPinBar = meetCustomCriteria(candle, candles);

		if (isPinBar)
			; // save
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

	private boolean meetCustomCriteria(Candle candle, TreeSet<Candle> candles) {
		if (candle.getBodySize() / (candle.getHigh() - candle.getLow()) > settings.getMaxNoseBodySize())
			return false;

		// todo to check if the logic for nose_body_position is correct
		if (candle.getOpen() > settings.getNoseBodyPosition() || candle.getClose() > settings.getNoseBodyPosition())
			return false;

		Candle left = candles.lower(candle);
		if (left == null
				|| (settings.isLeftEyeOppositeDirection() && left.getCandleType() == candle.getCandleType())
				|| (!settings.isLeftEyeOppositeDirection() && left.getCandleType() != candle.getCandleType()))
			return false;

		if (settings.isNoseBodyInsideLeftEyeBody() && !isInsideLeft(candle, left))
			return false;
		if (candle.getBodySize()/(candle.getLength()) < settings.getLeftEyeMinBodySize())
			return false;
		if (!isExceedsMinProtrusion(candle, left))
			return false;
		if ((candle.getBodySize() / left.getBodySize()) > settings.getNoseBodyToLeftEyeBody())
			return false;
		if (isNoseLengthLessLeftLength(candle, left))
			return false;
		if (!isLeftMeetDepth(candle, left))
			return false;

		return true;
	}

	private boolean isInsideLeft(Candle pattern, Candle left) {
		double topLeftNoseBorder 		= Double.max(left.getOpen(), left.getClose());
		double topPatternNoseBorder 	= Double.max(pattern.getOpen(), pattern.getClose());
		double bottomLeftNoseBorder 	= Double.min(left.getOpen(), left.getClose());
		double bottomPatternNoseBorder 	= Double.min(pattern.getOpen(), pattern.getClose());

		return (topPatternNoseBorder <= topLeftNoseBorder) && (bottomPatternNoseBorder >= bottomLeftNoseBorder);
	}

	private boolean isExceedsMinProtrusion(Candle pattern, Candle left) {
		double patternLength = pattern.getLength();
		double protrusion = getPoints(pattern.getInstrument(), pattern.getHigh() - left.getHigh());

		return (protrusion / patternLength) > settings.getNoseProtruding();
	}

	private boolean isNoseLengthLessLeftLength(Candle pattern, Candle left) {
		double patternLength = pattern.getLength();
		double leftLength = left.getLength();

		return (patternLength / leftLength) < settings.getNoseLengthToLeftEyeLength();
	}

	private boolean isLeftMeetDepth(Candle pattern, Candle left) {
		double leftLength = left.getLength();
		double leftDepth = getPoints(pattern.getInstrument(), pattern.getLow() - left.getLow());

		return (leftDepth / leftLength) >= settings.getLeftEyeDepth();
	}
}
