package exchange.analyzer.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity(name = "instruments")
public class InstrumentNameEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	private String name;

	public InstrumentNameEntity() {}

	public InstrumentNameEntity(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
