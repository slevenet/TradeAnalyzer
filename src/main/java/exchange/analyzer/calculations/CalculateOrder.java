package exchange.analyzer.calculations;

import exchange.analyzer.OrderManagerMS;
import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.model.Order;
import exchange.analyzer.model.autochartist.chartpattern.ChartPatternSignal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static exchange.analyzer.Util.getPointsByInstrument;

@Component
public class CalculateOrder {
    private Order order;

    @Autowired
    private OrderManagerMS orderManagerMS;

    public void calculateOrder(ChartPatternSignal pattern){
        double sl=0, tp=0, price=0;
        String instrument = pattern.getInstrument();
        //if BEARISH (open sell order)
        if(pattern.getMeta().getDirection() == BasicConstant.BEARISH){
            sl = pattern.getData().getPrediction().getPricehigh() - getPointsByInstrument(instrument, 7);
            tp = pattern.getData().getPrediction().getPricelow() +  getPointsByInstrument(instrument, 5);
            price = pattern.getData().getPoints().getResistance().getY1();
        }
        //if BULLISH (open buy order)
        else{
            tp = pattern.getData().getPrediction().getPricehigh() - getPointsByInstrument(instrument, 5);
            sl = pattern.getData().getPrediction().getPricelow() + getPointsByInstrument(instrument, 7);
            price = pattern.getData().getPoints().getResistance().getY1();
        }
        order = new Order("strategy",  "order_type",  sl,  tp, price, instrument);
        orderManagerMS.sendOrder(order);
    }
}
