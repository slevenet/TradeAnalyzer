package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAnalyzeFactory {

	@Autowired
	private StopLossAnalyzer stopLossAnalyzer;
	@Autowired
	private TakeProfitAnalyzer takeProfitAnalyzer;

	private OrderAnalyzeFactory() {}

	public OrderAnalyzeInfo analyze(OrderBook orderBook) {

		OrderAnalyzeResult stopLossResult 	= stopLossAnalyzer.analyze(orderBook);
		OrderAnalyzeResult takeProfitResult = takeProfitAnalyzer.analyze(orderBook);

		return new OrderAnalyzeInfo(stopLossResult, takeProfitResult);
	}
}
