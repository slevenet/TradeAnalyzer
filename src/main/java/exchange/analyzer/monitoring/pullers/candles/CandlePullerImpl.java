package exchange.analyzer.monitoring.pullers.candles;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.monitoring.pullers.abstraction.ScheduledDataPuller;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CandlePullerImpl extends ScheduledDataPuller implements CandlePuller {

    private static Logger logger = Logger.getLogger(CandlePullerImpl.class);

    public CandlePullerImpl() {
        logger.info("________________________CONSTRUCTOR_______________________");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

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
