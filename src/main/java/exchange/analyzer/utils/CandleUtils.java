package exchange.analyzer.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static exchange.analyzer.configuration.common.constants.BasicConstant.TABLEONEPOINT;
import static exchange.analyzer.configuration.common.constants.BasicConstant.TABLEONEPOINTINT;

public abstract class CandleUtils {

	public static double getPoints(String instrument, int points){
		return TABLEONEPOINT.get(instrument) * points;
	}

	public static int getPoints(String instrument, double price){
		double roundedPrice = new BigDecimal(price).setScale(5, RoundingMode.CEILING).doubleValue();
		return (int)(TABLEONEPOINTINT.get(instrument) * roundedPrice);
	}
}
