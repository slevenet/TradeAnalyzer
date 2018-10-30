package exchange.analyzer.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class ScheduleConstants {

    static final public int
            SECOND_FACTOR = 1000,
            MINUTE_FACTOR = SECOND_FACTOR * 60;

    static final public String price = "ABM";
    static final public List<String> CURRENCIES = new ArrayList<>(Arrays.asList("EUR_USD"));
    static final public List<String> GRANULARITIES = new ArrayList<>(Arrays.asList("M15", "M30", "H1", "H4", "D"));
    static final public List<Integer> PATTERN_PERIODS = new ArrayList<>(Arrays.asList(900, 1800, 3600, 14400, 86400));

}
