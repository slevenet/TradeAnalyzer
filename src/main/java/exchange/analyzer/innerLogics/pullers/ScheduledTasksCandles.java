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

    @Autowired
    private OandaContext oandaContext;
    @Autowired
    private CandlestickChartStorage chartStorage;

    @Scheduled(fixedRate = 60 * PullerConstants.SECOND_FACTOR)
    public void reportCurrentTime() throws ExecuteException, RequestException {

        for (String currency : PullerConstants.currencies){

            InstrumentName instrumentName = new InstrumentName(currency);

            InstrumentCandlesRequest candlesRequest = new InstrumentCandlesRequest(instrumentName);
            candlesRequest.setPrice("M");

            for (String neededGranularity : PullerConstants.granularities){
                CandlestickGranularity granularity = CandlestickGranularity.valueOf(neededGranularity);
                DateTime lastDateTime = chartStorage.getLastTimestamp(instrumentName, granularity);

                candlesRequest.setGranularity(granularity);
                if (lastDateTime != null)
                    candlesRequest.setFrom(lastDateTime);

                InstrumentCandlesResponse candlesResponse = oandaContext.getContext().instrument.candles(candlesRequest);

                chartStorage.addChart(instrumentName, granularity, candlesResponse.getCandles());
            }
        }

        System.out.println("_________________________________");
    }

}
