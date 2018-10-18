package exchange.analyzer.innerLogics.candlesCalculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CandlesCalculationConstants {

    static final int SECOND_FACTOR = 1000;

    static final String price = "ABM";
    static final List<String> currencies  = new ArrayList<>(Arrays.asList("EUR_USD"));
    static final List<String> granularities  = new ArrayList<>(Arrays.asList("M15", "H1", "H4", "D"));

}
