package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.instrument.OrderBookBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderAnalyzeFactory {

	@Autowired
	private StopLossAnalyzer stopLossAnalyzer;
	@Autowired
	private TakeProfitAnalyzer takeProfitAnalyzer;

	private OrderAnalyzeFactory() {}

	private OrderAnalyzeInfo analyze(OrderBook orderBook) {

		OrderAnalyzeResult stopLossResult 	= stopLossAnalyzer.analyze(orderBook);
		OrderAnalyzeResult takeProfitResult = takeProfitAnalyzer.analyze(orderBook);

		return new OrderAnalyzeInfo(stopLossResult, takeProfitResult);
	}

	public OrderAnalyzeInfo purifyAndAnalyze(OrderBook orderBook) {
		return analyze(purify(orderBook));
	}

	private OrderBook purify(OrderBook orderBook) {
		OrderBook pure = new OrderBook();
		pure.setInstrument(orderBook.getInstrument());
		pure.setTime(orderBook.getTime());
		pure.setPrice(orderBook.getPrice());
		pure.setBucketWidth(orderBook.getBucketWidth());

		List<OrderBookBucket> pureBuckets = new ArrayList<>(orderBook.getBuckets().size());

		orderBook.getBuckets().forEach(bucket -> {
			double purePercent = bucket
					.getLongCountPercent().bigDecimalValue()
					.subtract(bucket.getShortCountPercent().bigDecimalValue())
					.doubleValue();
			if (purePercent < 0) {
				bucket.setLongCountPercent(0);
				bucket.setShortCountPercent(Math.abs(purePercent));
			} else if (purePercent > 0) {
				bucket.setShortCountPercent(0);
				bucket.setLongCountPercent(Math.abs(purePercent));
			} else {
				bucket.setLongCountPercent(0);
				bucket.setShortCountPercent(0);
			}

			pureBuckets.add(bucket);
		});

		pure.setBuckets(pureBuckets);
		return pure;
	}
}
