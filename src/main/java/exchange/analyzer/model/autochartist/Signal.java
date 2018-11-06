package exchange.analyzer.model.autochartist;

import java.io.Serializable;

public abstract class Signal<T extends Prediction, P extends AbstractPoints> implements Serializable{

    private String      instrument;
    private Data<T, P>  data;
    private String      type;
    private long        id;
    private Meta        meta;

    protected Signal() {}

    public Signal(String instrument,
                  Data<T, P> data,
                  String type,
                  long id,
                  Meta meta) {
        this.instrument = instrument;
        this.data = data;
        this.type = type;
        this.id = id;
        this.meta = meta;
    }

    public String getInstrument() {
        return instrument;
    }

    public Data<T, P> getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void setData(Data<T, P> data) {
        this.data = data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
