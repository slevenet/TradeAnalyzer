package exchange.analyzer.entity;

import com.oanda.v20.instrument.OrderBookBucket;

import javax.persistence.*;

@Entity(name = "order_book_bucket")
public class OrderBookBucketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String price;
	private String longCountPercent;
	private String shortCountPercent;

	public OrderBookBucketEntity() {}

	public OrderBookBucketEntity(OrderBookBucket bucket) {
		this.price = bucket.getPrice().toString();
		this.longCountPercent = bucket.getLongCountPercent().toString();
		this.shortCountPercent = bucket.getShortCountPercent().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLongCountPercent() {
		return longCountPercent;
	}

	public void setLongCountPercent(String longCountPercent) {
		this.longCountPercent = longCountPercent;
	}

	public String getShortCountPercent() {
		return shortCountPercent;
	}

	public void setShortCountPercent(String shortCountPercent) {
		this.shortCountPercent = shortCountPercent;
	}
}
