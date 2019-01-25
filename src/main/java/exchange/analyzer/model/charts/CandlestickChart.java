package exchange.analyzer.model.charts;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.calculations.candlestick.EventManager;
import exchange.analyzer.configuration.common.keyManager.CurrencyKey;
import exchange.analyzer.configuration.common.keyManager.KeyManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CandlestickChart {

    public final EventManager events = new EventManager(Events.UPDATE);

    private Map<CurrencyKey, List<Candlestick>> candlestickMap = new HashMap<>();

    public void addCandlestickMap(CurrencyKey key, List<Candlestick> value){
        candlestickMap.putIfAbsent(key,value);
        candlestickMap.computeIfPresent(
                key,
                (a, b) -> Stream.concat(b.stream(), value.stream()).collect(Collectors.toList()));
        events.notify(Events.UPDATE);
    }

    public List<Candlestick> getCandles(CurrencyKey currencyKey){

        return candlestickMap.putIfAbsent(currencyKey, new ArrayList<>());
    }

    public DateTime getLastTimestamp(InstrumentName instrument, CandlestickGranularity granularity){
        CurrencyKey key = KeyManager.getKey(instrument, granularity);
        List<Candlestick> list = candlestickMap.getOrDefault(key, null);

        return list != null && !list.isEmpty()
                ? list.stream().reduce((a, b) -> b).get().getTime()
                : null;
    }
}