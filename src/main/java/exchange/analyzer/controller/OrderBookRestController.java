package exchange.analyzer.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("orderbook")
public class OrderBookRestController {


	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("charts")
	public void getCharts() {
//		StringBuilder res = new StringBuilder();
//
//		Gson gson = new Gson();
//		OrderBookChartAdapter adapter = new OrderBookChartAdapter();
//		for (OrderBookChart chart : orderBookChartStorage.getOrderBookChartMap().values()) {
//			res.append(adapter.toJson(chart));
//		}

	//	return new ArrayList<>(orderBookChartStorage.getOrderBookChartMap().values());
	}
}
