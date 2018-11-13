package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.instrument.OrderBookBucket;
import com.oanda.v20.pricing_common.PriceValue;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TakeProfitAnalyzer extends OrderAnalyzer {

	@Override
	protected double buyOrderPercent(OrderBook orderBook) {
		return Precision.round(orderBook.getBuckets().stream()
				.filter(x -> x.getPrice().bigDecimalValue().compareTo(orderBook.getPrice().bigDecimalValue()) > 0)
				.mapToDouble(x -> x.getShortCountPercent().doubleValue()).sum(), 4);
	}

	@Override
	protected double sellOrderPercent(OrderBook orderBook) {
		return Precision.round(orderBook.getBuckets().stream()
				.filter(x -> x.getPrice().bigDecimalValue().compareTo(orderBook.getPrice().bigDecimalValue()) < 0)
				.mapToDouble(x -> x.getLongCountPercent().doubleValue()).sum(), 4);
	}

	@Override
	protected OrderBookBucket searchNearestBuy(OrderBook orderBook) {
		List<OrderBookBucket> bucketList = orderBook.getBuckets();
		int start = 0;
		int end = bucketList.size() - 1;
		PriceValue marketPrice = orderBook.getPrice();

		while (start <= end) {
			int mid = (start + end) / 2;
			OrderBookBucket current = bucketList.get(mid);
			int comparison = current
					.getPrice().bigDecimalValue()
					.compareTo(marketPrice.bigDecimalValue());

			/** if marketPrice less */
			if (comparison > 0) {
				OrderBookBucket bucket = bucketList.get(mid - 1);
				int checkPrev = bucket
						.getPrice().bigDecimalValue()
						.compareTo(marketPrice.bigDecimalValue());

				if (checkPrev < 0) {
					while (!shortOrderExists(current)) {
						mid++;
						current = bucketList.get(mid);
					}
					return current;
				}
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return null;
	}

	@Override
	protected OrderBookBucket searchNearestSell(OrderBook orderBook) {
		List<OrderBookBucket> bucketList = orderBook.getBuckets();
		int start = 0;
		int end = bucketList.size() - 1;
		PriceValue marketPrice = orderBook.getPrice();

		while (start <= end) {
			int mid = (start + end) / 2;
			OrderBookBucket current = bucketList.get(mid);
			int comparison = current
					.getPrice().bigDecimalValue()
					.compareTo(marketPrice.bigDecimalValue());

			/** if marketPrice greater */
			if (comparison < 0) {
				OrderBookBucket bucket = bucketList.get(mid + 1);
				int checkNext = bucket
						.getPrice().bigDecimalValue()
						.compareTo(marketPrice.bigDecimalValue());

				if (checkNext > 0) {
					while (!longOrderExists(current)) {
						mid--;
						current = bucketList.get(mid);
					}
					return current;
				}
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return null;
	}
}
