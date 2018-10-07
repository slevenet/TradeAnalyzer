package exchange.analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyzerRestAPI {

    @GetMapping("/hello")
    public String home()
    {
        return "Hello, World!2";
    }
}
