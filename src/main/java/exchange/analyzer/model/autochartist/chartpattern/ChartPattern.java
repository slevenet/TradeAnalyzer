package exchange.analyzer.model.autochartist.chartpattern;

import java.io.Serializable;
import java.util.List;

public class ChartPattern implements Serializable{

    private String provider;
    private List<Signal> signals;

    public ChartPattern() {}

    public ChartPattern(String provider,
                        List<Signal> signals) {
        this.provider = provider;
        this.signals = signals;
    }

    public String getProvider() {
        return provider;
    }

    public List<Signal> getSignals() {
        return signals;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }
}
