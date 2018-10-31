package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.AutochartistOperations;
import exchange.analyzer.innerLogics.storages.ChartPatternStorage;
import exchange.analyzer.model.autochartist.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AutochartistOperationsImpl implements AutochartistOperations {

    @Autowired
    ChartPatternStorage chartPatternStorage;

    public Map<Long, Signal> getPatterns() {
        return chartPatternStorage.getPatterns();
    }

    public Map<Long, Signal> getPatterns(String instrument) {
        return chartPatternStorage.getPatterns();
    }

    public Map<Long, Signal> getPatternMain() {
        return chartPatternStorage.getPatterns();
    }

    public Map<Long, Signal> getPatternMain(String instrument) {
        return chartPatternStorage.getPatterns();
    }

   // public Map<Long, Signal> getPatterns(String pattern) {
   //     return chartPatternStorage.getPatterns();
   // }

    //public getPattern
}
