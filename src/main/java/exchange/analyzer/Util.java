package exchange.analyzer;

import static exchange.analyzer.configuration.common.constants.BasicConstant.SUPPORTED_INSTRUMENT;
import static exchange.analyzer.configuration.common.constants.BasicConstant.TABLEONEPOINT;

public class Util {

   public static boolean isSupportedInstrument(String instrument){
        return SUPPORTED_INSTRUMENT.stream().anyMatch(instrument::equals);
    }

    public static double getPointsByInstrument(String instrument, int points){
       return TABLEONEPOINT.get(instrument) * points;
    }
}
