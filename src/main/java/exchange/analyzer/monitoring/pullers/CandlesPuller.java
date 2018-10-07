package exchange.analyzer.monitoring.pullers;

import com.oanda.v20.Context;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CandlesPuller extends DataPuller {
    private static Logger logger = Logger.getLogger(CandlesPuller.class);

    private static final String
            INSTRUMENT_NAME = "EUR_USD";
        //    PRICE = "ABM";

    private static final List<String> prices = new ArrayList<String>(){{
        add("M15");
        add("M30");
        add("H1");
        add("H4");
        add("D");
    }};

    public CandlesPuller(Context context) {
        super(context);
    }

    @Override
    public void run() {
        logger.info("START CANDLES PULLING");

        try {
            pullData();
        } catch (Exception e) {
            logger.error(e);
        }

        logger.info("END CANDLES PULLING");
    }

    @Override
    protected void pullData() throws Exception {

        InstrumentName instrumentName = new InstrumentName(INSTRUMENT_NAME);

        InstrumentCandlesRequest candlesRequest = new InstrumentCandlesRequest(instrumentName);
        candlesRequest.setPrice("M");


            CandlestickGranularity granularity = CandlestickGranularity.valueOf("M");

            candlesRequest.setGranularity(granularity);

            InstrumentCandlesResponse candlesResponse = context.instrument.candles(candlesRequest);

            System.out.println("__________________________________");
            System.out.println(candlesResponse.getCandles());

    }
}
