package exchange.analyzer.service;

import exchange.analyzer.entity.autochartist.chartpattern.Signal;
import exchange.analyzer.model.charts.ChartPatternModel;
import exchange.analyzer.model.autochartist.chartpattern.ChartPattern;

public interface SignalService {

    void addSignal(Signal signal);

    void addSignal(ChartPatternModel chartPattern);
}
