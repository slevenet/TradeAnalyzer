package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.AutochartistOperations;
import exchange.analyzer.storages.ChartPatternStorage;
import exchange.analyzer.model.autochartist.chartpattern.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AutochartistOperationsImpl implements AutochartistOperations {

    @Autowired
    private ChartPatternStorage chartPatternStorage;

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

    public Map<Long,List<String>> getScores(String instrument){
        Map<Long,List<String>> scoresList = new HashMap<>();
        chartPatternStorage.getSignals(instrument).forEach(signal -> {
            scoresList.put(signal.getId(), new ArrayList<>());
            scoresList.get(signal.getId()).add(String.valueOf(signal.getMeta().getScores().getInitialtrend()));
            scoresList.get(signal.getId()).add(String.valueOf(signal.getMeta().getScores().getBreakout()));
            scoresList.get(signal.getId()).add(String.valueOf(signal.getMeta().getScores().getClarity()));
            scoresList.get(signal.getId()).add(String.valueOf(signal.getMeta().getScores().getQuality()));
            scoresList.get(signal.getId()).add(String.valueOf(signal.getMeta().getScores().getUniformity()));
        });
        return scoresList;
    }

    public Map<Long,List<String>> getPrediction(String instrument){
        Map<Long,List<String>> predictionList = new HashMap<>();
        chartPatternStorage.getSignals(instrument).forEach(signal -> {
            predictionList.put(signal.getId(), new ArrayList<>());
            predictionList.get(signal.getId()).add(String.valueOf(signal.getData().getPrediction().getPricehigh()));
            predictionList.get(signal.getId()).add(String.valueOf(signal.getData().getPrediction().getPricelow()));
            predictionList.get(signal.getId()).add(String.valueOf(signal.getData().getPrediction().getTimefrom()));
            predictionList.get(signal.getId()).add(String.valueOf(signal.getData().getPrediction().getTimeto()));
        });
        return predictionList;
    }

    public Map<Long,List<String>> getMeta(String instrument){
        Map<Long,List<String>> metaList = new HashMap<>();
        chartPatternStorage.getSignals(instrument).forEach(signal -> {
            metaList.put(signal.getId(), new ArrayList<>());
            metaList.get(signal.getId()).add(String.valueOf(signal.getMeta().getInterval()));
            metaList.get(signal.getId()).add(String.valueOf(signal.getMeta().getDirection()));
            metaList.get(signal.getId()).add(signal.getMeta().getPattern());
            metaList.get(signal.getId()).add(String.valueOf(signal.getMeta().getProbability()));
            metaList.get(signal.getId()).add(signal.getMeta().getTrendtype());
        });
        return metaList;
    }

    public Map<Long,List<String>> getSignalDate(String instrument){
        Map<Long,List<String>> signalDateList = new HashMap<>();
        chartPatternStorage.getSignals(instrument).forEach(signal -> {
            signalDateList.put(signal.getId(), new ArrayList<>());
            signalDateList.get(signal.getId()).add(String.valueOf(signal.getData().getPatternendtime()));
        });
        return signalDateList;
    }

}
