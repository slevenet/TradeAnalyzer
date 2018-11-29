package exchange.analyzer.model.charts;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeInfo;
import java.util.HashMap;
import java.util.Map;

public class OrderBookChart {

    private InstrumentName instrumentName;
    private Map<DateTime, OrderBook> orderBookMap;
    private Map<DateTime, OrderAnalyzeInfo> analyzeResultMap;

    public OrderBookChart() {
        this.orderBookMap       = new HashMap<>();
        this.analyzeResultMap   = new HashMap<>();
    }

    public OrderBookChart(InstrumentName instrumentName) {
        this();
        this.instrumentName     = instrumentName;
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

    public void setInstrumentName(InstrumentName instrumentName) {
        this.instrumentName = instrumentName;
    }

    public void setOrderBookMap(Map<DateTime, OrderBook> orderBookMap) {
        this.orderBookMap = orderBookMap;
    }

    public void setAnalyzeResultMap(Map<DateTime, OrderAnalyzeInfo> analyzeResultMap) {
        this.analyzeResultMap = analyzeResultMap;
    }
}
