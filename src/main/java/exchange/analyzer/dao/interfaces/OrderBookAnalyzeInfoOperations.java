package exchange.analyzer.dao.interfaces;

import exchange.analyzer.entity.OrderAnalyzeInfoEntity;
import exchange.analyzer.entity.OrderAnalyzeInfoId;

public interface OrderBookAnalyzeInfoOperations {

	void persist(OrderAnalyzeInfoEntity analyzeInfoEntity);
	OrderAnalyzeInfoEntity load(OrderAnalyzeInfoId id);
}
