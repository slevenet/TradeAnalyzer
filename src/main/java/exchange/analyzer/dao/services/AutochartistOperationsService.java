package exchange.analyzer.dao.services;

import exchange.analyzer.dao.implementation.AutochartistOperationsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AutochartistOperationsService {

    private Map<String, Map<Long,List<String>>> aggregatedData = new HashMap<>();

    @Autowired
    AutochartistOperationsImpl autochartistOperations;

    public Map<String, Map<Long,List<String>>> getAggregatedData(String instrument){
        aggregatedData.put("meta",autochartistOperations.getMeta(instrument));
        aggregatedData.put("prediction",autochartistOperations.getPrediction(instrument));
        aggregatedData.put("scores",autochartistOperations.getScores(instrument));
        aggregatedData.put("signaldate",autochartistOperations.getSignalDate(instrument));
        return aggregatedData;
    }
}
