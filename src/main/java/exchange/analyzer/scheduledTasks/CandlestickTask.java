package exchange.analyzer.scheduledTasks;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.storages.CandlestickChartStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class CandlestickTask extends OandaTask {

    private static final Logger logger = LoggerFactory.getLogger(CandlestickTask.class);

    @Autowired
    private CandlestickChartStorage chartStorage;

//    @Scheduled(fixedRate = 15 * ScheduleConstants.MINUTE_FACTOR)
    public void process(){
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
            InstrumentName instrumentName = new InstrumentName(currency);

            InstrumentCandlesRequest request = new InstrumentCandlesRequest(instrumentName);
            request.setPrice(ScheduleConstants.price);

            ScheduleConstants.GRANULARITIES.forEach(requestedGranularity ->
            {
                CandlestickGranularity granularity = CandlestickGranularity.valueOf(requestedGranularity);
                request.setGranularity(granularity);

                DateTime lastTimestamp = chartStorage.getLastTimestamp(instrumentName, granularity);
                if (lastTimestamp != null)
                    request.setFrom(lastTimestamp);

                try {
                    InstrumentCandlesResponse candlesResponse = oandaContext.getContext().instrument.candles(request);
                    chartStorage.addChart(instrumentName, granularity, candlesResponse.getCandles());
                } catch (Exception e) {
                    logger.error("Error during candlestick task", e);
                }
            });
        });
    }
}
