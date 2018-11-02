package exchange.analyzer.controller;

import exchange.analyzer.innerLogics.storages.ChartPatternStorage;
import exchange.analyzer.model.autochartist.chartpattern.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AutochartistRestController {

    @Autowired
    private ChartPatternStorage autochartistOperationsService;

    @GetMapping("/autochartist")
    public Map<Long, Signal>  getPatterns(){
        return autochartistOperationsService.getPatterns();
    }
}
