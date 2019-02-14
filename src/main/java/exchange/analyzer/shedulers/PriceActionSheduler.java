package exchange.analyzer.shedulers;

import org.springframework.stereotype.Component;

@Component
public class PriceActionSheduler extends CandlestickComponentSheduler {
    @Override
    protected void process() {
        getCandles(10L);
    }
}
