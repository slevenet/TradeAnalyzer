package exchange.analyzer.model;

import com.oanda.v20.instrument.Candlestick;
import org.springframework.stereotype.Component;

@Component
public class CandlestickModel {

   private Candlestick candlestick;
   private String granularity;
   private String t;

}
