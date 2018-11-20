package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.google.gson.annotations.JsonAdapter;
import exchange.analyzer.calculations.orderBook.OrderAnalyzeInfoAdapter;

@JsonAdapter(OrderAnalyzeInfoAdapter.class)
public class OrderAnalyzeInfo {

	private OrderAnalyzeResult stopLossResult;
	private OrderAnalyzeResult takeProfitResult;

	public OrderAnalyzeInfo(OrderAnalyzeResult stopLossResult,
							OrderAnalyzeResult takeProfitResult) {
		this.stopLossResult = stopLossResult;
		this.takeProfitResult = takeProfitResult;
	}

	public OrderAnalyzeResult getStopLossResult() {
		return stopLossResult;
	}

	public OrderAnalyzeResult getTakeProfitResult() {
		return takeProfitResult;
	}

	@Override
	public String toString() {
		return "OrderAnalyzeInfo{" +
				"stopLossResult=" + stopLossResult +
				", takeProfitResult=" + takeProfitResult +
				'}';
	}
}
