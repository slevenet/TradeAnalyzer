package exchange.analyzer.model.autochartist.chartpattern;

import java.io.Serializable;

public class Points implements Serializable{

    private Point support;
    private Point resistance;

    public Points() {
    }

    public Points(Point support,
                  Point resistance) {
        this.support = support;
        this.resistance = resistance;
    }

    public Point getSupport() {
        return support;
    }

    public Point getResistance() {
        return resistance;
    }
}
