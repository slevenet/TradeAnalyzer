package exchange.analyzer.controller;

import exchange.analyzer.model.charts.CandlestickChart;
import exchange.analyzer.storages.CandlestickChartStorage;
import exchange.analyzer.storages.OrderBookChartStorage;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/main")
public class MainRestController {

    @Autowired
    private OrderBookChartStorage orderBookChartStorage;

    @Autowired
    private CandlestickChartStorage candlestickChartStorage;

    @GetMapping("/orderbook")
    public List<OrderBookChart> home() {
        return new ArrayList<>(orderBookChartStorage.getOrderBookChartMap().values());
    }

    @GetMapping("/ogo")
    public List<CandlestickChart> name() {
        return candlestickChartStorage.getCandlestickChartList();
    }
}
