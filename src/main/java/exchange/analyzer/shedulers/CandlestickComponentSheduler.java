package exchange.analyzer.shedulers;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.instrument.InstrumentCandlesRequest;
import com.oanda.v20.instrument.InstrumentCandlesResponse;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.model.Candle;
import exchange.analyzer.model.ExternalCandleWrapper;
import exchange.analyzer.priceaction.StartPriceAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CandlestickComponentSheduler extends OandaComponentSheduler {

    private static final Logger logger = LoggerFactory.getLogger(CandlestickComponentSheduler.class);

    @Autowired
    private StartPriceAction startPriceAction;

    @Scheduled(fixedRate = 60 * ScheduleConstants.MINUTE_FACTOR)
    public void process(){
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
            InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName(currency));
            request.setPrice(ScheduleConstants.price).setCount(10L);
            ScheduleConstants.GRANULARITIES.forEach(requestedGranularity ->
            {
                CandlestickGranularity granularity = CandlestickGranularity.valueOf(requestedGranularity);
                request.setGranularity(granularity);

                try {
                    ExternalCandleWrapper externalCandleWrapper = new ExternalCandleWrapper();
                    InstrumentCandlesResponse candlesResponse = oandaContext.getContext().instrument.candles(request);
                    externalCandleWrapper.setCandlestick(candlesResponse.getCandles());
                    externalCandleWrapper.setInstrument(currency);
                    externalCandleWrapper.setTf(requestedGranularity);
                    startPriceAction.process(getCandlesFromOandaCandels(externalCandleWrapper));
                } catch (Exception e) {
                    logger.error("Error during candlestick task", e);
                }
            });
        });
    }

    private List<Candle> getCandlesFromOandaCandels(ExternalCandleWrapper candlesticks){
      return candlesticks.getCandlestick().stream()
              .map(Candle::new)
              .collect(Collectors.toList())
                .stream()
                .peek(candle -> {
                    candle.setTf(candlesticks.getTf());
                    candle.setInstrument((candlesticks.getInstrument()));
                })
              .collect(Collectors.toList());
    }
}
