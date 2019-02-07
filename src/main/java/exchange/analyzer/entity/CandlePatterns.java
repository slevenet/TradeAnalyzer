package exchange.analyzer.entity;

import exchange.analyzer.CandlePatternsListner;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@EntityListeners(CandlePatternsListner.class)
@Table(name = "CANDLEPATTERNS")
public class CandlePatterns {

    @Id
    private BigInteger id;
    private String timeStamp;
    private String tf;
    private String type;
    private BigInteger parent_id;
}
