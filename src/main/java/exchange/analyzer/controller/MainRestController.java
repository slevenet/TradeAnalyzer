package exchange.analyzer.controller;

import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.storages.OrderBookChartStorage;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainRestController {

    @Autowired
    private OrderBookChartStorage orderBookChartStorage;

    @GetMapping("/rest")
    public Map<InstrumentName, OrderBookChart> home()
    {
        return orderBookChartStorage.getOrderBookChartMap();

    }
}
