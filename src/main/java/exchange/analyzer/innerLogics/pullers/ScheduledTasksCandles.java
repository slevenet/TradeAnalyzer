package exchange.analyzer.innerLogics.pullers;

import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.storage.CandlestickChartStorage;
import exchange.analyzer.model.OandaContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasksCandles {

    private OandaContext oandaContext;
    private CandlestickChartStorage chartStorage;

    @Autowired
    public ScheduledTasksCandles(OandaContext oandaContext, CandlestickChartStorage chartStorage) {
        this.oandaContext = oandaContext;
        this.chartStorage = chartStorage;
    }

    @Scheduled(fixedRate = 60 * PullerConstants.SECOND_FACTOR)
    public void reportCurrentTime() throws ExecuteException, RequestException {

        for (String currency : PullerConstants.currencies){
            InstrumentName instrumentName = new InstrumentName(currency);

            InstrumentCandlesRequest request = new InstrumentCandlesRequest(instrumentName);
            request.setPrice(PullerConstants.price);

            for (String requestedGranularity : PullerConstants.granularities){
                CandlestickGranularity granularity = CandlestickGranularity.valueOf(requestedGranularity);

                request.setGranularity(granularity);

                DateTime lastTimestamp = chartStorage.getLastTimestamp(instrumentName, granularity);
                if (lastTimestamp != null)
                    request.setFrom(lastTimestamp);

                InstrumentCandlesResponse candlesResponse = oandaContext.getContext().instrument.candles(request);

                chartStorage.addChart(instrumentName, granularity, candlesResponse.getCandles());
            }
        }
    }

}
