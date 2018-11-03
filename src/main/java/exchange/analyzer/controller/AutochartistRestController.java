package exchange.analyzer.controller;

import exchange.analyzer.dao.services.AutochartistOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("autochartist")
public class AutochartistRestController {

    @Autowired
    private AutochartistOperationsService autochartistOperationsService;

    @GetMapping("{instrument}")
    public Map<String, Map<Long,List<String>>> getPatterns(@PathVariable String instrument){
        return autochartistOperationsService.getAggregatedData(instrument);
    }
}
