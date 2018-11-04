package exchange.analyzer.model.autochartist.chartpattern;

import java.io.Serializable;

public class Signal implements Serializable{

    private String  instrument;
    private Data    data;
    private String  type;
    private long    id;
    private Meta    meta;

    public Signal() {}

    public Signal(Data data,
                  String type,
                  String instrument,
                  long id,
                  Meta meta) {
        this.instrument = instrument;
        this.data   = data;
        this.type   = type;
        this.id     = id;
        this.meta   = meta;
    }

    public Data getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public String getInstrument() {
        return instrument;
    }

    public long getId() {
        return id;
    }

    public Meta getMeta() {
        return meta;
    }
}
