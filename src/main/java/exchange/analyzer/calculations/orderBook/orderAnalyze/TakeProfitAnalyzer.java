package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBook;
import org.springframework.stereotype.Component;
import java.util.OptionalDouble;

@Component
public class TakeProfitAnalyzer extends OrderAnalyzer {

	@Override
	protected double buyOrderPercent(OrderBook orderBook) {
		OptionalDouble average = orderBook.getBuckets().stream()
				.filter(x -> x.getPrice().bigDecimalValue().compareTo(orderBook.getPrice().bigDecimalValue()) > 0)
				.mapToDouble(x -> x.getShortCountPercent().doubleValue()).average();

		return average.orElse(0);
	}

	@Override
	protected double sellOrderPercent(OrderBook orderBook) {
		OptionalDouble average = orderBook.getBuckets().stream()
				.filter(x -> x.getPrice().bigDecimalValue().compareTo(orderBook.getPrice().bigDecimalValue()) < 0)
				.mapToDouble(x -> x.getLongCountPercent().doubleValue()).average();

		return average.orElse(0);
	}
}
