package exchange.analyzer.storages;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeFactory;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderBookChartStorage {

    @Autowired
    private OrderAnalyzeFactory analyzeFactory;
    private Map<InstrumentName, OrderBookChart> orderBookChartMap = new HashMap<>();

    public void addOrderBook(OrderBook orderBook){
        InstrumentName instrumentName = orderBook.getInstrument();

        OrderBookChart chart = orderBookChartMap.containsKey(instrumentName)
                ? orderBookChartMap.get(instrumentName)
                : new OrderBookChart(instrumentName);
        chart.addOrderBook(orderBook, analyzeFactory.analyze(orderBook));

        orderBookChartMap.putIfAbsent(chart.getInstrumentName(), chart);
    }

    public Map<InstrumentName, OrderBookChart> getOrderBookChartMap() {
        return orderBookChartMap;
    }
}
