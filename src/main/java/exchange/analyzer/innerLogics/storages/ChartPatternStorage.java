package exchange.analyzer.innerLogics.storages;

import exchange.analyzer.model.autochartist.ChartPattern;
import exchange.analyzer.model.autochartist.Signal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ChartPatternStorage {

    private Map<String, List<Signal>> patterns = new HashMap<>();

    public void addPatterns(ChartPattern chartPattern){

        chartPattern.getSignals().forEach(signal ->
        {
            String instrument = signal.getInstrument();

            patterns.putIfAbsent(instrument, new ArrayList<>());
            patterns.get(instrument).add(signal);
        });
    }

    public List<Signal> getSignal(String instrumentName){
        return patterns.putIfAbsent(instrumentName, new ArrayList<>());
    }

    public Map<String, List<Signal>> getPatterns() {
        return patterns;
    }
}
