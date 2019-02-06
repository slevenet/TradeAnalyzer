package exchange.analyzer.controller;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("orderbook")
public class OrderBookRestController {


	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("charts")
	public void getCharts() {


		}
}
