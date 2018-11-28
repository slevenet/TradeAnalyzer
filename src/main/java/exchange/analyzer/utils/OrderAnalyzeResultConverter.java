package exchange.analyzer.utils;

import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeResult;
import exchange.analyzer.entity.OrderAnalyzeResultEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderAnalyzeResultConverter {

	public OrderAnalyzeResultEntity toEntity(OrderAnalyzeResult analyzeResult) {
		return new OrderAnalyzeResultEntity(analyzeResult);
	}
}
