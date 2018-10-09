package exchange.analyzer.monitoring.pullers.candles;

import java.util.ArrayList;
import java.util.List;

public interface CandlePuller {
    String
            INSTRUMENT_NAME = "EUR_USD";

    List<String> prices = new ArrayList<String>(){{
        add("M15");
        add("M30");
        add("H1");
        add("H4");
        add("D");
    }};
}
