package exchange.analyzer.dao.interfaces;

import exchange.analyzer.entity.OrderBookChartEntity;

public interface OrderBookChartOperations {

	void persist(OrderBookChartEntity orderBookChart);
	Integer save(OrderBookChartEntity orderBookChart);
	OrderBookChartEntity load(Integer id);
	OrderBookChartEntity loadByNaturalId(Integer instrumentNameId);
}
