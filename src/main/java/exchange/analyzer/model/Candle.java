package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;

import static exchange.analyzer.configuration.common.constants.BasicConstant.*;
import static exchange.analyzer.configuration.common.constants.BasicConstant.BULLISH;
import static exchange.analyzer.utils.CandleUtils.getPoints;
import static java.lang.StrictMath.abs;

public class Candle extends CandleModel {

    public Candle(Candlestick candelOanda)  {
        super(candelOanda);
    }

    public int getCandleType(){
        if(getOpen() > getClose())
            return BEARISH;
        return BULLISH;
    }

    public int getTopShadow(){
        if (getCandleType() == BEARISH){
            return getPoints(getInstrument(), this.getHigh() - this.getOpen());
        }
        return getPoints(getInstrument(),this.getHigh() - this.getClose());
    }

    public int getLowShadow(){
        if (getCandleType() == BEARISH){
            return getPoints(getInstrument(),this.getClose() - this.getLow());
        }
        return getPoints(getInstrument(),this.getOpen() - this.getLow());
    }

    public int getBodySize(){
        return getPoints(getInstrument(), abs(this.getOpen() - this.getClose()));
    }

    public int getLength() {
        return getPoints(getInstrument(), this.getHigh() - this.getLow());
    }
}
