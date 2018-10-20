package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.calculations.candlestick.EventManager;
import exchange.analyzer.innerLogics.calculations.candlestick.Events;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CandlestickChart {

    public EventManager events = new EventManager(Events.UPDATE);

    private InstrumentName instrumentName;
    private CandlestickGranularity granularity;
    private DateTime lastTimestamp;

    private List<Candlestick> candlestickList;

    private Map<String, List<Candlestick>> candlestickMap = new HashMap<>();

    public void addCandlesticks(List<Candlestick> candlestickList) {
        this.candlestickList.addAll(candlestickList);
        this.lastTimestamp = candlestickList.get(candlestickList.size() - 1).getTime();
    }

    public Map<String, List<Candlestick>> getCandlestickMap() {
        return candlestickMap;
    }

    public CandlestickGranularity getGranularity() {
        return granularity;
    }

    public List<Candlestick> getCandlestickList() {
        return candlestickList;
    }

    public InstrumentName getInstrumentName() {
        return instrumentName;
    }

    public DateTime getLastTimestamp() {
        return lastTimestamp;
    }

    public void addCandlestickMap(String key, List<Candlestick> value){
        candlestickMap.putIfAbsent(key,value);
        candlestickMap.computeIfPresent(
                key,
                (a, b) -> Stream.concat(b.stream(), value.stream()).collect(Collectors.toList()));
        events.notify(Events.UPDATE);
    }

}