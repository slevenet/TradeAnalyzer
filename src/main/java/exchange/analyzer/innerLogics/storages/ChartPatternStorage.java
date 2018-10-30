package exchange.analyzer.innerLogics.storages;

import exchange.analyzer.innerLogics.Util;
import exchange.analyzer.model.autochartist.ChartPattern;
import exchange.analyzer.model.autochartist.Signal;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
}
