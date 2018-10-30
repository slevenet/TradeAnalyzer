package exchange.analyzer.controller;

import exchange.analyzer.dao.services.AutochartistOperationsService;
import exchange.analyzer.innerLogics.storages.ChartPatternStorage;
import exchange.analyzer.model.autochartist.Signal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AutochartistRestController {

    @Autowired
    ChartPatternStorage autochartistOperationsService;

    @GetMapping("/autochartist")
    public Map<Long, Signal>  getPatterns(){
        return autochartistOperationsService.getPatterns();
    }
}
