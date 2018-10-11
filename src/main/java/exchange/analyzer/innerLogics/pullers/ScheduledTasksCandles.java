package exchange.analyzer.innerLogics.pullers;

import java.util.Date;

import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.Constants;
import exchange.analyzer.model.OandaContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasksCandles {

    @Autowired
    OandaContext oandaContext;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws ExecuteException, RequestException {
        InstrumentName instrumentName = new InstrumentName(Constants.CandlePuller.EUR_USD);

        InstrumentCandlesRequest candlesRequest = new InstrumentCandlesRequest(instrumentName);
        candlesRequest.setPrice("M");

        CandlestickGranularity granularity = CandlestickGranularity.valueOf("M");

        candlesRequest.setGranularity(granularity);

        InstrumentCandlesResponse candlesResponse = oandaContext.getContext().instrument.candles(candlesRequest);

        System.out.println("__________________________________");
        System.out.println(candlesResponse.getCandles());
    }

}
