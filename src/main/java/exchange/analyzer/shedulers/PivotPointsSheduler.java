package exchange.analyzer.shedulers;


import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.model.Candle;
import exchange.analyzer.model.PivotPoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public class PivotPointsSheduler extends CandlestickComponentSheduler {

    @Override
    @Scheduled(fixedDelay = 3600000)
    protected void process() {
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
           System.out.println( new PivotPoint(oandaComponent.getCandles(1L,currency,"W").last()).toString());
        });
    }
}
