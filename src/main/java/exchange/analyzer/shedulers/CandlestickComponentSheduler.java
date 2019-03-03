package exchange.analyzer.shedulers;


import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.model.Candle;
import exchange.analyzer.model.CandleComporator;
import exchange.analyzer.model.ExternalCandleWrapper;
import exchange.analyzer.priceaction.StartPriceAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;


public abstract class CandlestickComponentSheduler extends Sheduler {

    private static final Logger logger = LoggerFactory.getLogger(CandlestickComponentSheduler.class);

    @Autowired
    protected StartPriceAction startPriceAction;

    public void getCandles(Long size){
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
            ScheduleConstants.GRANULARITIES.forEach(requestedGranularity ->
            {
                startPriceAction.process(oandaComponent.getCandles(size,currency,requestedGranularity));

            });
        });
    }
}
