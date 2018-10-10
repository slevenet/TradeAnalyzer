package exchange.analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @GetMapping("/rest")
    public String home()
    {
        return "Hello, World!2";
    }
}
