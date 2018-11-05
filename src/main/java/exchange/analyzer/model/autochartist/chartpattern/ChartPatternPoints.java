package exchange.analyzer.model.autochartist.chartpattern;

import exchange.analyzer.model.autochartist.AbstractPoints;

public class ChartPatternPoints extends AbstractPoints {

    private ChartPatternPoint support;
    private ChartPatternPoint resistance;

    public ChartPatternPoints() {}

    public ChartPatternPoints(ChartPatternPoint support,
                              ChartPatternPoint resistance) {
        this.support = support;
        this.resistance = resistance;
    }

    public ChartPatternPoint getSupport() {
        return support;
    }

    public ChartPatternPoint getResistance() {
        return resistance;
    }
}
