package exchange.analyzer.calculations.orderBook.orderAnalyze;

import com.google.gson.annotations.JsonAdapter;
import com.oanda.v20.instrument.OrderBookBucket;
import com.oanda.v20.pricing_common.PriceValue;
import exchange.analyzer.calculations.orderBook.OrderAnalyzeResultAdapter;

@JsonAdapter(OrderAnalyzeResultAdapter.class)
public class OrderAnalyzeResult {
	private boolean orderExist;
	private boolean isNearestBuy;
	private boolean isNearestSell;
	private double 	buyOrderPercent;
	private double 	sellOrderPercent;

	private OrderBookBucket nearestBuy;
	private OrderBookBucket nearestSell;

	public OrderAnalyzeResult(PriceValue marketPrice,
							  double buyOrderPercent,
							  double sellOrderPercent,
							  OrderBookBucket nearestBuy,
							  OrderBookBucket nearestSell) {
		this.orderExist = nearestBuy != null || nearestSell != null;
		this.buyOrderPercent = buyOrderPercent;
		this.sellOrderPercent = sellOrderPercent;
		this.nearestBuy = nearestBuy;
		this.nearestSell = nearestSell;

		checkNearest(nearestBuy, nearestSell, marketPrice);
	}

	private void checkNearest(OrderBookBucket nearestBuy,
							  OrderBookBucket nearestSell,
							  PriceValue marketPrice) {
		if (nearestBuy != null && nearestSell != null) {
			double v1 = Math.abs(nearestBuy.getPrice().bigDecimalValue().subtract(marketPrice.bigDecimalValue()).doubleValue());
			double v2 = Math.abs(nearestSell.getPrice().bigDecimalValue().subtract(marketPrice.bigDecimalValue()).doubleValue());
			if (v1 < v2) {
				this.isNearestBuy = true;
				this.isNearestSell = false;
			} else if (v2 < v1) {
				this.isNearestBuy = false;
				this.isNearestSell = true;
			} else {
				this.isNearestBuy = true;
				this.isNearestSell = true;
			}
		} else if (nearestBuy == null && nearestSell == null) {
			this.isNearestBuy = false;
			this.isNearestSell = false;
		} else if (nearestBuy == null) {
			this.isNearestBuy = false;
			this.isNearestSell = true;
		} else {
			this.isNearestSell = false;
			this.isNearestBuy = true;
		}
	}

	public boolean isOrderExist() {
		return orderExist;
	}

	public boolean isNearestBuy() {
		return isNearestBuy;
	}

	public boolean isNearestSell() {
		return isNearestSell;
	}

	public boolean bothNereast() {
		return isNearestSell && isNearestBuy;
	}

	public double getBuyOrderPercent() {
		return buyOrderPercent;
	}

	public double getSellOrderPercent() {
		return sellOrderPercent;
	}

	public OrderBookBucket getNearestBuy() {
		return nearestBuy;
	}

	public OrderBookBucket getNearestSell() {
		return nearestSell;
	}

	@Override
	public String toString() {
		return "OrderAnalyzeResult{" +
				"orderExist=" + orderExist +
				", isNearestBuy=" + isNearestBuy +
				", isNearestSell=" + isNearestSell +
				", buyOrderPercent=" + buyOrderPercent +
				", sellOrderPercent=" + sellOrderPercent +
				", nearestBuy=" + nearestBuy +
				", nearestSell=" + nearestSell +
				'}';
	}
}
