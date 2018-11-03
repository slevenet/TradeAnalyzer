package exchange.analyzer.configuration.common.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class BasicConstant {
    public static final List<String> SUPPORTED_INSTRUMENT = new ArrayList<>(Arrays.asList(
            "EUR_USD", "AUD_USD", "EUR_AUD",
            "EUR_JPY", "GBP_JPY", "GBP_USD",
            "NZD_USD", "USD_CAD", "USD_CHF",
            "USD_JPY", "XAU_USD"));
}
