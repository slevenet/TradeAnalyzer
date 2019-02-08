package exchange.analyzer.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "SIGNALS")
public class Signals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }
}
