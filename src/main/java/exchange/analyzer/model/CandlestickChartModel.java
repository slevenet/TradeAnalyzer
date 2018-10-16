package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import java.util.List;

public class CandlestickChartModel {

    private InstrumentName instrumentName;
    private CandlestickGranularity granularity;
    private DateTime lastTimestamp;

    private List<Candlestick> candlestickList;

    public CandlestickChartModel(InstrumentName instrumentName,
                                 CandlestickGranularity granularity,
                                 List<Candlestick> candlestickList) {
        this.instrumentName = instrumentName;
        this.granularity = granularity;
        this.candlestickList = candlestickList;
    }

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
}
