package exchange.analyzer.model.autochartist.chartpattern;

import exchange.analyzer.model.autochartist.Pattern;

import java.util.List;

public class ChartPattern extends Pattern<ChartPatternSignal> {

    private String provider;

    public ChartPattern() {}

    public ChartPattern(List<ChartPatternSignal> signals, String provider) {
        super(signals);
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
