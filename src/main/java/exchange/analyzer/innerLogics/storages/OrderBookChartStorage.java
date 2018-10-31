package exchange.analyzer.innerLogics.storages;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderBookChartStorage {

    private Map<InstrumentName, OrderBookChart> orderBookChartMap = new HashMap<>();

    public void addOrderBook(OrderBook orderBook){
        InstrumentName instrumentName = orderBook.getInstrument();

        OrderBookChart chart = orderBookChartMap.containsKey(instrumentName)
                ? orderBookChartMap.get(instrumentName)
                : new OrderBookChart(instrumentName);
        chart.addOrderBook(orderBook);

        orderBookChartMap.putIfAbsent(chart.getInstrumentName(), chart);
    }

    public Map<InstrumentName, OrderBookChart> getOrderBookChartMap() {
        return orderBookChartMap;
    }
}
