package exchange.analyzer.entity;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity(name = "order_book_chart")
public class OrderBookChartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NaturalId
	@Column(name = "instrumentName_id", updatable = false, unique = true)
	private Integer instrumentNameId;

	public OrderBookChartEntity() {}

	public Integer getId() {
		return id;
	}

	public Integer getInstrumentNameId() {
		return instrumentNameId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInstrumentNameId(Integer instrumentNameId) {
		this.instrumentNameId = instrumentNameId;
	}
}
