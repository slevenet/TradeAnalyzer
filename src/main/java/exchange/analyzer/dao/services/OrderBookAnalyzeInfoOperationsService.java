package exchange.analyzer.dao.services;

import exchange.analyzer.dao.implementation.OrderBookAnalyzeInfoOperationsImpl;
import exchange.analyzer.entity.OrderAnalyzeInfoEntity;
import exchange.analyzer.entity.OrderAnalyzeInfoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBookAnalyzeInfoOperationsService {

	@Autowired
	private OrderBookAnalyzeInfoOperationsImpl orderBookAnalyzeInfoOperations;

	public void persist(OrderAnalyzeInfoEntity analyzeInfoEntity) {
		orderBookAnalyzeInfoOperations.persist(analyzeInfoEntity);
	}

	public OrderAnalyzeInfoEntity load(OrderAnalyzeInfoId id) {
		return orderBookAnalyzeInfoOperations.load(id);
	}
}
