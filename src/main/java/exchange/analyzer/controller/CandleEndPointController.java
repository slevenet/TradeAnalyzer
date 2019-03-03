package exchange.analyzer.controller;

import exchange.analyzer.model.Candle;
import exchange.analyzer.utils.OandaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TreeSet;

@RestController
@RequestMapping("candle")
public class CandleEndPointController {

    @Autowired
    OandaComponent oandaComponent;

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("get")
    public TreeSet<Candle> getCandles(){
        return oandaComponent.getCandles(100L, "EUR_USD","D");
    }
}
