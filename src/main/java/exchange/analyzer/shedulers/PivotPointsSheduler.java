package exchange.analyzer.shedulers;


import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.entity.PivotPointEntity;
import exchange.analyzer.model.Candle;
import exchange.analyzer.model.PivotPoint;
import exchange.analyzer.service.impl.PivotPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public class PivotPointsSheduler extends CandlestickComponentSheduler {

    @Autowired
    PivotPointImpl pivotPoint;

    @Override
    @Scheduled(fixedDelay = 3600000)
    protected void process() {
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
            PivotPoint pPoint = new PivotPoint(oandaComponent.getCandles(1L,currency,"W").last());
            pivotPoint.insert(new PivotPointEntity(
                    pPoint.getInstrument(),
                    pPoint.getTf(),
                    pPoint.getR1(),
                    pPoint.getS1(),
                    pPoint.getR2(),
                    pPoint.getS2(),
                    pPoint.getR3(),
                    pPoint.getS3(),
                    pPoint.getPivotPoint()
            ));
        });
    }
}
