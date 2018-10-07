package trade.analyzer.controller;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickData;
import com.oanda.v20.instrument.CandlestickGranularity;
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
