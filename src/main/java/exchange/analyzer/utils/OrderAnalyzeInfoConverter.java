package exchange.analyzer.utils;

import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeInfo;
import exchange.analyzer.entity.OrderAnalyzeInfoEntity;
import exchange.analyzer.entity.OrderAnalyzeInfoId;
import exchange.analyzer.entity.OrderAnalyzeResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAnalyzeInfoConverter {

	@Autowired
	private OrderAnalyzeResultConverter analyzeResultConverter;

	public OrderAnalyzeInfoEntity toEntity(OrderAnalyzeInfoId id, OrderAnalyzeInfo analyzeInfo) {
		OrderAnalyzeResultEntity stopLossResult = analyzeResultConverter.toEntity(analyzeInfo.getStopLossResult());
		OrderAnalyzeResultEntity takeProfitResult = analyzeResultConverter.toEntity(analyzeInfo.getTakeProfitResult());

		return new OrderAnalyzeInfoEntity(id, stopLossResult, takeProfitResult);
	}
}
