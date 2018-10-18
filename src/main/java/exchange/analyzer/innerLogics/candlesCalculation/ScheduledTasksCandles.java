package exchange.analyzer.innerLogics.candlesCalculation;

import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
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

    @Scheduled(fixedRate = 15 * 60 * CandlesCalculationConstants.SECOND_FACTOR )
    public void reportCurrentTime()  {

        CandlesCalculationConstants.currencies.forEach(currency ->{
            InstrumentName instrumentName = new InstrumentName(currency);
            InstrumentCandlesRequest request = new InstrumentCandlesRequest(instrumentName);
            request.setPrice(CandlesCalculationConstants.price);
            CandlesCalculationConstants.granularities.forEach(requestedGranularity ->{
                CandlestickGranularity granularity = CandlestickGranularity.valueOf(requestedGranularity);

                 request.setGranularity(granularity);

                 DateTime lastTimestamp = chartStorage.getLastTimestamp(instrumentName, granularity);
                 if (lastTimestamp != null)
                     request.setFrom(lastTimestamp);

                 InstrumentCandlesResponse candlesResponse = null;
                 try {
                     candlesResponse = oandaContext.getContext().instrument.candles(request);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

                 chartStorage.addChart(instrumentName, granularity, candlesResponse.getCandles());
            }
            );
        }
        );

    }

}
