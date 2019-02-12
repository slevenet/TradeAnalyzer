package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import static exchange.analyzer.configuration.common.constants.BasicConstant.*;
import static exchange.analyzer.configuration.common.constants.BasicConstant.BULLISH;
import static java.lang.StrictMath.abs;

public class Candle extends CandleModel {

    public Candle(Candlestick candelOanda)  {
        super(candelOanda);
    }

    public double getPoints(int points){
        return TABLEONEPOINT.get(getInstrument()) * points;
    }

    public  int getPoints(double price){
        double roundedPrice = new BigDecimal(price).setScale(5, RoundingMode.CEILING).doubleValue();
        return (int)(TABLEONEPOINTINT.get(getInstrument()) * roundedPrice);
    }

    public int getCandleType(){
        if(getOpen() > getClose())
            return BEARISH;
        return BULLISH;
    }

    public int getTopShadow(){
        if (getCandleType() == BEARISH){
            return getPoints(this.getHigh() - this.getOpen());
        }
         return getPoints(this.getHigh() - this.getClose());
    }

    public int getLowShadow(){
        if (getCandleType() == BEARISH){
            return getPoints(this.getClose() - this.getLow());
        }
        return getPoints(this.getOpen() - this.getLow());
    }

    public int getBodySize(){
        return getPoints(abs(this.getOpen() - this.getClose()));
    }
}
