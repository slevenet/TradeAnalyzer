package exchange.analyzer.entity.autochartist.chartpattern;

import javax.persistence.*;

@Entity
@Table(name = "ac_signal")
public class Signal{

    private String  instrument;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="data_id")
    private Data data;

    public Signal() {
    }

    private String  type;

    @Id
    @Column(name = "signal_id")
    private long    id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="meta_id")
    private Meta meta;


    public String getInstrument() {
        return instrument;
    }

    public Signal(String instrument, Data data, String type, long id, Meta meta) {
        this.instrument = instrument;
        this.data = data;
        this.type = type;
        this.id = id;
        this.meta = meta;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
