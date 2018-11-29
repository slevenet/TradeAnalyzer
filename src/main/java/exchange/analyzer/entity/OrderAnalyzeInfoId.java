package exchange.analyzer.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderAnalyzeInfoId implements Serializable{

	private String dateTime;
	private Integer orderBookChartId;

	public OrderAnalyzeInfoId() {}

	public OrderAnalyzeInfoId(String dateTime, Integer orderBookChartId) {
		this.dateTime = dateTime;
		this.orderBookChartId = orderBookChartId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getOrderBookChartId() {
		return orderBookChartId;
	}

	public void setOrderBookChartId(Integer orderBookChartId) {
		this.orderBookChartId = orderBookChartId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderAnalyzeInfoId)) return false;

		OrderAnalyzeInfoId that = (OrderAnalyzeInfoId) o;

		return Objects.equals(dateTime, that.dateTime) &&
				Objects.equals(orderBookChartId, that.orderBookChartId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, orderBookChartId);
	}
}
