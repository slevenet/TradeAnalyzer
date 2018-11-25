package exchange.analyzer.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exchange.analyzer.calculations.orderBook.OrderBookChartAdapter;
import exchange.analyzer.model.charts.OrderBookChart;
import exchange.analyzer.storages.OrderBookChartStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orderbook")
public class OrderBookRestController {

	@Autowired
	private OrderBookChartStorage orderBookChartStorage;

	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("charts")
	public List<OrderBookChart> getCharts() {
		System.out.println("\nORDER BOOK CONTROLLER \n");
//		StringBuilder res = new StringBuilder();
//
//		Gson gson = new Gson();
//		OrderBookChartAdapter adapter = new OrderBookChartAdapter();
//		for (OrderBookChart chart : orderBookChartStorage.getOrderBookChartMap().values()) {
//			res.append(adapter.toJson(chart));
//		}

		return new ArrayList<>(orderBookChartStorage.getOrderBookChartMap().values());
	}
}