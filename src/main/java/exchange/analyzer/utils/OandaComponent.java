package exchange.analyzer.utils;

import com.oanda.v20.Context;
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
import exchange.analyzer.shedulers.CandlestickComponentSheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class OandaComponent {
    private static final Logger logger = LoggerFactory.getLogger(CandlestickComponentSheduler.class);

    @Autowired
    protected Context context;

    public TreeSet<Candle> getCandles(Long size, String instrument, String tf){
            InstrumentCandlesRequest request = new InstrumentCandlesRequest(new InstrumentName(instrument));
            request.setPrice(ScheduleConstants.price).setCount(size);
            ExternalCandleWrapper externalCandleWrapper = new ExternalCandleWrapper();
            CandlestickGranularity granularity = CandlestickGranularity.valueOf(tf);
            request.setGranularity(granularity);

                try {
                    InstrumentCandlesResponse candlesResponse = context.instrument.candles(request);
                    externalCandleWrapper.setCandlestick(candlesResponse.getCandles());
                    externalCandleWrapper.setInstrument(instrument);
                    externalCandleWrapper.setTf(tf);
                } catch (Exception e) {
                    logger.error("Error during candlestick task", e);
                }
        return getCandlesFromOandaCandels(externalCandleWrapper);
    }

    private TreeSet<Candle> getCandlesFromOandaCandels(ExternalCandleWrapper candlesticks) {
        return candlesticks.getCandlestick().stream()
                .map(Candle::new)
                .collect(Collectors.toList())
                .stream()
                .peek(candle -> {
                    candle.setTf(candlesticks.getTf());
                    candle.setInstrument((candlesticks.getInstrument()));
                })
                .collect(Collectors.toCollection(() ->
                        new TreeSet<Candle>(new CandleComporator())));
    }
}
