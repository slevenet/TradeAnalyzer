package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.candlesCalculation.EventManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CandlestickChartModel {
    public EventManager events;

    public Map<String, List<Candlestick>> getCandlestickCharMap() {
        return candlestickCharMap;
    }

    private InstrumentName instrumentName;
    private CandlestickGranularity granularity;
    private DateTime lastTimestamp;

    private List<Candlestick> candlestickList;

    private Map<String, List<Candlestick>> candlestickCharMap = new HashMap<>();


    public void addCandlesticks(List<Candlestick> candlestickList)
    {
        this.candlestickList.addAll(candlestickList);
        this.lastTimestamp = candlestickList.get(candlestickList.size() - 1).getTime();
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

    public void addCandlestickCharMap(String key, List<Candlestick> value){
        candlestickCharMap.putIfAbsent(key,value);
        candlestickCharMap.computeIfPresent(key, (a,b)-> Stream.concat(b.stream(),value.stream()).collect(Collectors.toList()));
        events.notify("save");

    }

}