package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.oanda.v20.instrument.OrderBookBucket;

public class OrderAnalyzeResult {
	private boolean orderExist;
	private boolean nearestSell;

	private double buyOrderPercent;
	private double sellOrderPercent;

	private OrderBookBucket nearestOrder;

	public OrderAnalyzeResult(boolean orderExist,
							  boolean nearestSell,
							  double buyOrderPercent,
							  double sellOrderPercent,
							  OrderBookBucket nearestOrder) {
		this.orderExist = orderExist;
		this.nearestSell = nearestSell;
		this.buyOrderPercent = buyOrderPercent;
		this.sellOrderPercent = sellOrderPercent;
		this.nearestOrder = nearestOrder;
	}

	public boolean isOrderExist() {
		return orderExist;
	}

	public boolean isNearestSell() {
		return nearestSell;
	}

	public double getBuyOrderPercent() {
		return buyOrderPercent;
	}

	public double getSellOrderPercent() {
		return sellOrderPercent;
	}

	public OrderBookBucket getNearestOrder() {
		return nearestOrder;
	}
}
