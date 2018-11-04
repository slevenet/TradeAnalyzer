package exchange.analyzer.storages;

import exchange.analyzer.Util;
import exchange.analyzer.model.autochartist.chartpattern.ChartPattern;
import exchange.analyzer.model.autochartist.chartpattern.Signal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ChartPatternStorage {

    private Map<Long, Signal> patterns = new HashMap<>();

    public void addPatterns(ChartPattern chartPattern){

        chartPattern.getSignals().forEach(signal -> {
            if (Util.isSupportedInstrument(signal.getInstrument()))
                patterns.putIfAbsent(signal.getId(), signal);
        });

    }

    public Map<Long, Signal> getPatterns() {
        return patterns;
    }

    public List<Signal> getSignals(){
        List<Signal> signals = new ArrayList<>(patterns.values());
        return signals;
    }

    public List<Signal> getSignals(String instrument){
        List<Signal> signals = getSignals().stream().filter(signal ->
                signal.getInstrument().equals(instrument)).collect(Collectors.toCollection(ArrayList::new));
        return signals;
    }
}
