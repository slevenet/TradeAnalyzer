package exchange.analyzer.entity;

import javax.persistence.*;

@Entity(name = "order_book_analyze_info")
public class OrderAnalyzeInfoEntity {

	@EmbeddedId
	private OrderAnalyzeInfoId id;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderAnalyzeResultEntity stopLossResult;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderAnalyzeResultEntity takeProfitResult;

	public OrderAnalyzeInfoEntity() {}

	public OrderAnalyzeInfoEntity(OrderAnalyzeInfoId id,
								  OrderAnalyzeResultEntity stopLossResult,
								  OrderAnalyzeResultEntity takeProfitResult) {
		this.id = id;
		this.stopLossResult = stopLossResult;
		this.takeProfitResult = takeProfitResult;
	}

	public OrderAnalyzeInfoId getId() {
		return id;
	}

	public OrderAnalyzeResultEntity getStopLossResult() {
		return stopLossResult;
	}

	public OrderAnalyzeResultEntity getTakeProfitResult() {
		return takeProfitResult;
	}

	public void setId(OrderAnalyzeInfoId id) {
		this.id = id;
	}

	public void setStopLossResult(OrderAnalyzeResultEntity stopLossResult) {
		this.stopLossResult = stopLossResult;
	}

	public void setTakeProfitResult(OrderAnalyzeResultEntity takeProfitResult) {
		this.takeProfitResult = takeProfitResult;
	}
}
