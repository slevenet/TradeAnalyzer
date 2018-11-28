package exchange.analyzer.dao.services;

import exchange.analyzer.dao.implementation.OrderBookChartOperationsImpl;
import exchange.analyzer.entity.OrderAnalyzeInfoEntity;
import exchange.analyzer.entity.OrderAnalyzeInfoId;
import exchange.analyzer.entity.OrderBookChartEntity;
import exchange.analyzer.model.charts.OrderBookChart;
import exchange.analyzer.utils.OrderAnalyzeInfoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookChartOperationsService {

	@Autowired
	private OrderBookChartOperationsImpl orderBookChartOperations;
	@Autowired
	private InstrumentNameOperationsService instrumentNameOperationsService;
	@Autowired
	private OrderBookAnalyzeInfoOperationsService analyzeInfoOperationsService;
	@Autowired
	private OrderAnalyzeInfoConverter analyzeInfoConverter;

	public void persist(OrderBookChart orderBookChart) {
		Integer instrumentNameId = instrumentNameOperationsService.persist(orderBookChart.getInstrumentName());

		OrderBookChartEntity entity = getEntity(instrumentNameId);

		orderBookChart.getAnalyzeResultMap().forEach((dateTime, analyzeInfo) -> {
			OrderAnalyzeInfoId id = new OrderAnalyzeInfoId(dateTime.toString(), entity.getId());
			OrderAnalyzeInfoEntity check = analyzeInfoOperationsService.load(id);
			if (check == null)
				analyzeInfoOperationsService.persist(analyzeInfoConverter.toEntity(id, analyzeInfo));
		});
	}

	private OrderBookChartEntity getEntity(Integer instrumentNameId) {
		OrderBookChartEntity entity = orderBookChartOperations.loadByNaturalId(instrumentNameId);
		if (entity == null) {
			entity = new OrderBookChartEntity();
			entity.setInstrumentNameId(instrumentNameId);
			entity.setId(orderBookChartOperations.save(entity));
		}

		return entity;
	}
}
