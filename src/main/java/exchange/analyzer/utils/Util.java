package exchange.analyzer.utils;


import static exchange.analyzer.configuration.common.constants.BasicConstant.*;

public class Util {

   public static boolean isSupportedInstrument(String instrument){
        return SUPPORTED_INSTRUMENT.stream().anyMatch(instrument::equals);
    }

}
