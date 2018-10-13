package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.InstrumentName;

import java.util.ArrayList;
import java.util.List;

public class CandlestickChartModel {

    private InstrumentName instrumentName;
    private CandlestickGranularity granularity;
    private List<Candlestick> candlestickList;

    public CandlestickChartModel(InstrumentName instrumentName, CandlestickGranularity granularity, List<Candlestick> candlestickList) {
        this.instrumentName = instrumentName;
        this.granularity = granularity;
        this.candlestickList = candlestickList;
    }

    public CandlestickChartModel(InstrumentName instrumentName, CandlestickGranularity granularity) {
        this(instrumentName, granularity, new ArrayList<>());
    }

    public void addCandlesticks(List<Candlestick> candlestickList)
    {
        this.candlestickList.addAll(candlestickList);
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
}
