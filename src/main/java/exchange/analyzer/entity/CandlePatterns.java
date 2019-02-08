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

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTf() {
        return tf;
    }

    public void setTf(String tf) {
        this.tf = tf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigInteger getParent_id() {
        return parent_id;
    }

    public void setParent_id(BigInteger parent_id) {
        this.parent_id = parent_id;
    }
}
