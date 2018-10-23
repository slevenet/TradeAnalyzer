package exchange.analyzer.innerLogics.scheduledTasks;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.scheduledTasks.abstracts.OandaTask;
import exchange.analyzer.innerLogics.storages.CandlestickChartStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CandlestickTask extends OandaTask {

    @Autowired
    private CandlestickChartStorage chartStorage;

    @Scheduled(fixedRate = 15 * ScheduleConstants.MINUTE_FACTOR)
    public void process(){
        ScheduleConstants.currencies.forEach(currency ->
        {
            InstrumentName instrumentName = new InstrumentName(currency);

            InstrumentCandlesRequest request = new InstrumentCandlesRequest(instrumentName);
            request.setPrice(ScheduleConstants.price);

            ScheduleConstants.granularities.forEach(requestedGranularity ->
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
                    e.printStackTrace();
                }
            });
        });
    }
}
