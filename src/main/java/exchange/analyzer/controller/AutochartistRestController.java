package exchange.analyzer.controller;

import exchange.analyzer.dao.services.AutochartistOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutochartistRestController {

    @Autowired
    AutochartistOperationsService autochartistOperationsService;

    @GetMapping("/autochartist")
    public List<String> getPatterns(){
        return null;
    }
}
