package exchange.analyzer.entity;

import exchange.analyzer.CandlePatternsListner;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@EntityListeners(CandlePatternsListner.class)
@Table(name = "")
public class CandlePatterns {
}
