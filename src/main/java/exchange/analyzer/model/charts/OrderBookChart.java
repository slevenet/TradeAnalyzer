package exchange.analyzer.model.charts;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeFactory;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class OrderBookChart {

    private InstrumentName instrumentName;
    private Map<DateTime, OrderBook> orderBookMap;
    private Map<OrderBook, OrderAnalyzeInfo> analyzeResultMap;

    public OrderBookChart(InstrumentName instrumentName) {
        this.instrumentName     = instrumentName;
        this.orderBookMap       = new HashMap<>();
        this.analyzeResultMap   = new HashMap<>();
    }

    public void addOrderBook(OrderBook orderBook, OrderAnalyzeInfo analyzeInfo){
        if (instrumentName.equals(orderBook.getInstrument())) {
            orderBookMap.put(orderBook.getTime(), orderBook);
            analyzeResultMap.put(orderBook, analyzeInfo);
        }
    }

    public InstrumentName getInstrumentName() {
        return instrumentName;
    }

    public Map<DateTime, OrderBook> getOrderBookMap() {
        return orderBookMap;
    }
}
