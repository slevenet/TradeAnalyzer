package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;

import static exchange.analyzer.configuration.common.constants.BasicConstant.*;
import static exchange.analyzer.configuration.common.constants.BasicConstant.BULLISH;

public class Candle extends CandleModel {

    public Candle(Candlestick candelOanda) {
        super(candelOanda);
    }

    public double getPoints(int points){
        return TABLEONEPOINT.get(getInstrument()) * points;
    }

    public  int getPoints(double price){
        return (int) (TABLEONEPOINTINT.get(getInstrument()) * price);
    }

    public int getCandleType(){
        if(getOpen() > getClose())
            return BEARISH;
        return BULLISH;
    }
}
