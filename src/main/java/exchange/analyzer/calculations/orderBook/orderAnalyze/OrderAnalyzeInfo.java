package exchange.analyzer.calculations.orderBook.orderAnalyze;

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
}
