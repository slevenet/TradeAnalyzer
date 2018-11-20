package exchange.analyzer.model.charts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.JsonAdapter;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.calculations.orderBook.OrderBookChartAdapter;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeInfo;
import java.util.HashMap;
import java.util.Map;

@JsonAdapter(OrderBookChartAdapter.class)
public class OrderBookChart {

    private InstrumentName instrumentName;
    private Map<DateTime, OrderBook> orderBookMap;
    private Map<DateTime, OrderAnalyzeInfo> analyzeResultMap;

    public OrderBookChart(InstrumentName instrumentName) {
        this.instrumentName     = instrumentName;
        this.orderBookMap       = new HashMap<>();
        this.analyzeResultMap   = new HashMap<>();
    }

    public void addOrderBook(OrderBook orderBook, OrderAnalyzeInfo analyzeInfo){
        if (instrumentName.equals(orderBook.getInstrument())) {
            orderBookMap.put(orderBook.getTime(), orderBook);
            analyzeResultMap.put(orderBook.getTime(), analyzeInfo);
        }
    }

    public InstrumentName getInstrumentName() {
        return instrumentName;
    }

    public Map<DateTime, OrderBook> getOrderBookMap() {
        return orderBookMap;
    }

    public Map<DateTime, OrderAnalyzeInfo> getAnalyzeResultMap() {
        return analyzeResultMap;
    }
}
