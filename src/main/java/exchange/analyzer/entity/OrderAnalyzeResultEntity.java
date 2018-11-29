package exchange.analyzer.entity;

import com.oanda.v20.instrument.OrderBookBucket;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeResult;

import javax.persistence.*;

@Entity(name = "order_analyze_result")
public class OrderAnalyzeResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean orderExist;
	private Boolean isNearestBuy;
	private Boolean isNearestSell;
	private Double 	buyOrderPercent;
	private Double 	sellOrderPercent;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderBookBucketEntity nearestBuy;
	@OneToOne(cascade = CascadeType.ALL)
	private OrderBookBucketEntity nearestSell;

	public OrderAnalyzeResultEntity() {}

	public OrderAnalyzeResultEntity(OrderAnalyzeResult orderAnalyzeResult) {
		this.orderExist = orderAnalyzeResult.isOrderExist();
		this.isNearestBuy = orderAnalyzeResult.isNearestBuy();
		this.isNearestSell = orderAnalyzeResult.isNearestSell();
		this.buyOrderPercent = orderAnalyzeResult.getBuyOrderPercent();
		this.sellOrderPercent = orderAnalyzeResult.getSellOrderPercent();

		OrderBookBucket nearestBuy = orderAnalyzeResult.getNearestBuy();
		OrderBookBucket nearestSell = orderAnalyzeResult.getNearestSell();

		this.nearestBuy = nearestBuy == null ? null : new OrderBookBucketEntity(nearestBuy);
		this.nearestSell = nearestSell == null ? null : new OrderBookBucketEntity(nearestSell);
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

	public OrderBookBucketEntity getNearestBuy() {
		return nearestBuy;
	}

	public OrderBookBucketEntity getNearestSell() {
		return nearestSell;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrderExist(boolean orderExist) {
		this.orderExist = orderExist;
	}

	public void setNearestBuy(boolean nearestBuy) {
		isNearestBuy = nearestBuy;
	}

	public void setNearestSell(boolean nearestSell) {
		isNearestSell = nearestSell;
	}

	public void setBuyOrderPercent(double buyOrderPercent) {
		this.buyOrderPercent = buyOrderPercent;
	}

	public void setSellOrderPercent(double sellOrderPercent) {
		this.sellOrderPercent = sellOrderPercent;
	}

	public void setNearestBuy(OrderBookBucketEntity nearestBuy) {
		this.nearestBuy = nearestBuy;
	}

	public void setNearestSell(OrderBookBucketEntity nearestSell) {
		this.nearestSell = nearestSell;
	}
}
