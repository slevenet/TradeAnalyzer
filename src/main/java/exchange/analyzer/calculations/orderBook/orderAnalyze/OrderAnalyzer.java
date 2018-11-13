package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.instrument.OrderBookBucket;
import com.oanda.v20.pricing_common.PriceValue;

import java.math.BigDecimal;

public abstract class OrderAnalyzer {

	protected abstract double buyOrderPercent(OrderBook orderBook);
	protected abstract double sellOrderPercent(OrderBook orderBook);
	protected abstract OrderBookBucket searchNearestBuy(OrderBook orderBook);
	protected abstract OrderBookBucket searchNearestSell(OrderBook orderBook);

	public OrderAnalyzeResult analyze(OrderBook orderBook) {
		PriceValue marketPrice 		= orderBook.getPrice();

		double buyOrderPercent 		= buyOrderPercent(orderBook);
		double sellOrderPercent 	= sellOrderPercent(orderBook);
		OrderBookBucket nearestBuy 	= buyOrderPercent != 0 ? searchNearestBuy(orderBook) : null;
		OrderBookBucket nearestSell = sellOrderPercent != 0 ? searchNearestSell(orderBook) : null;

		return new OrderAnalyzeResult(marketPrice, buyOrderPercent, sellOrderPercent, nearestBuy, nearestSell);
	}

	protected boolean shortOrderExists(OrderBookBucket bucket) {
		return bucket.getShortCountPercent() != null
				&& bucket.getShortCountPercent().bigDecimalValue().compareTo(new BigDecimal(0)) > 0;
	}

	protected boolean longOrderExists(OrderBookBucket bucket) {
		return bucket.getLongCountPercent() != null
				&& bucket.getLongCountPercent().bigDecimalValue().compareTo(new BigDecimal(0)) > 0;
	}
}
