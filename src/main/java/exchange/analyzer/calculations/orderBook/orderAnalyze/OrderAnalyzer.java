package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.instrument.OrderBookBucket;
import com.oanda.v20.pricing_common.PriceValue;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public abstract class OrderAnalyzer {

	protected abstract double buyOrderPercent(OrderBook orderBook);
	protected abstract double sellOrderPercent(OrderBook orderBook);

	public OrderAnalyzeResult analyze(OrderBook orderBook) {
		PriceValue marketPrice 		= orderBook.getPrice();

		double buyOrderPercent 		= buyOrderPercent(orderBook);
		double sellOrderPercent 	= sellOrderPercent(orderBook);
		OrderBookBucket nearestBuy 	= buyOrderPercent != 0 ? searchNearestBuy(orderBook) : null;
		OrderBookBucket nearestSell = sellOrderPercent != 0 ? searchNearestSell(orderBook) : null;
		OrderBookBucket nearest 	= chooseNearest(nearestBuy, nearestSell, marketPrice);
		boolean nearestShort 		= isNearestSell(nearest, marketPrice);

		return new OrderAnalyzeResult(nearest != null, nearestShort, buyOrderPercent, sellOrderPercent, nearest);
	}

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

			/** if marketPrice greater */
			if (comparison < 0) {
				OrderBookBucket bucket = bucketList.get(mid + 1);
				int checkNext = bucket
						.getPrice().bigDecimalValue()
						.compareTo(marketPrice.bigDecimalValue());

				if (checkNext > 0) {
					while (!shortOrderExists(current)) {
						mid--;
						current = bucketList.get(mid);
					}
					return current;
				}

				start = mid + 1;
			}
		}
		return null;
	}

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

			/** if marketPrice less */
			if (comparison > 0) {
				OrderBookBucket bucket = bucketList.get(mid - 1);
				int checkPrev = bucket
						.getPrice().bigDecimalValue()
						.compareTo(marketPrice.bigDecimalValue());

				if (checkPrev < 0) {
					while (!longOrderExists(current)) {
						mid++;
						current = bucketList.get(mid);
					}
					return current;
				}

				end = mid - 1;
			}
		}
		return null;
	}

	protected boolean shortOrderExists(OrderBookBucket bucket) {
		return bucket.getShortCountPercent() != null
				&& bucket.getShortCountPercent().bigDecimalValue().compareTo(new BigDecimal(0)) > 0;
	}

	protected boolean longOrderExists(OrderBookBucket bucket) {
		return bucket.getLongCountPercent() != null
				&& bucket.getLongCountPercent().bigDecimalValue().compareTo(new BigDecimal(0)) > 0;
	}

	protected OrderBookBucket chooseNearest(OrderBookBucket nearestBuy,
											OrderBookBucket nearestSell,
											PriceValue marketPrice) {
		if (nearestBuy != null && nearestSell != null) {
			double v1 = Math.abs(nearestBuy.getPrice().doubleValue() - marketPrice.doubleValue());
			double v2 = Math.abs(nearestSell.getPrice().doubleValue() - marketPrice.doubleValue());
			return v1 < v2 ? nearestBuy : nearestSell;
		} else {
			return nearestBuy == null && nearestSell == null ? null : nearestBuy != null ? nearestBuy : nearestSell;
		}
	}

	protected boolean isNearestSell(OrderBookBucket nearest,
									PriceValue marketPrice) {
		return nearest != null && nearest.getPrice().bigDecimalValue().compareTo(marketPrice.bigDecimalValue()) > 0;
	}
}
