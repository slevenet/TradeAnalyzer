package exchange.analyzer.model;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;

import java.util.HashMap;
import java.util.Map;

public class OrderBookChart {

    private InstrumentName instrumentName;
    private Map<DateTime, OrderBook> orderBookMap;

    public OrderBookChart(InstrumentName instrumentName) {
        this.instrumentName = instrumentName;
        this.orderBookMap = new HashMap<>();
    }

    public void addOrderBook(OrderBook orderBook){
        if (instrumentName.equals(orderBook.getInstrument()))
            orderBookMap.put(orderBook.getTime(), orderBook);
    }

    public InstrumentName getInstrumentName() {
        return instrumentName;
    }

    public Map<DateTime, OrderBook> getOrderBookMap() {
        return orderBookMap;
    }
}
