package exchange.analyzer.innerLogics;

import static exchange.analyzer.configuration.common.constants.BasicConstant.SUPPORTED_INSTRUMENT;

public class Util {

   public static boolean isSupportedInstrument(String instrument){
        return SUPPORTED_INSTRUMENT.stream().anyMatch(instrument::equals);
    }
}
