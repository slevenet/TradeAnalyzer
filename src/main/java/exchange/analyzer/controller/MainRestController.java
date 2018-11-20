package exchange.analyzer.controller;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.storages.OrderBookChartStorage;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/main")
public class MainRestController {

    @Autowired
    private OrderBookChartStorage orderBookChartStorage;

    @GetMapping("/orderbook")
    public List<OrderBookChart> home() {
        return new ArrayList<>(orderBookChartStorage.getOrderBookChartMap().values());
    }

    @GetMapping("ogo")
    public InstrumentName name() {
        return new InstrumentName("some instrument");
    }
}
