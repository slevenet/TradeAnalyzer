package exchange.analyzer.scheduledTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class ScheduleConstants {

    static final int
            SECOND_FACTOR = 1000,
            MINUTE_FACTOR = SECOND_FACTOR * 60;

    static final String price = "ABM";
    static final List<String> CURRENCIES = new ArrayList<>(Arrays.asList("EUR_USD"));
    static final List<String> GRANULARITIES = new ArrayList<>(Arrays.asList("M15", "M30", "H1", "H4", "D"));
    static final List<Integer> PATTERN_PERIODS = new ArrayList<>(Arrays.asList(900, 1800, 3600, 14400, 86400));

}
