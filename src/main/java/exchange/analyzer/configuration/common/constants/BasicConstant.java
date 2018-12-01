package exchange.analyzer.configuration.common.constants;

import java.util.*;

final public class BasicConstant {
    public static final List<String> SUPPORTED_INSTRUMENT = new ArrayList<>(Arrays.asList(
            "EUR_USD", "AUD_USD", "EUR_AUD",
            "EUR_JPY", "GBP_JPY", "GBP_USD",
            "NZD_USD", "USD_CAD", "USD_CHF",
            "USD_JPY", "XAU_USD"));

    public static final int BULLISH =   1;
    public static final int BEARISH =  -1;

    public static final Map<String, Double> TABLEONEPOINT = new HashMap() {{
        put("EUR_USD",0.0001);
        put("AUD_USD",0.0001);
        put("EUR_AUD",0.0001);
        put("EUR_JPY",0.01);
        put("GBP_JPY",0.01);
        put("GBP_USD",0.0001);
        put("NZD_USD",0.0001);
        put("USD_CAD",0.0001);
        put("USD_CHF",0.0001);
        put("USD_JPY",0.01);
        put("XAU_USD",0.01);
    }};
}
