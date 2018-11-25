package exchange.analyzer.calculations;

import exchange.analyzer.OrderManagerMS;
import exchange.analyzer.model.Order;
import exchange.analyzer.model.autochartist.chartpattern.ChartPatternSignal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculateOrder {
    private Order order;

    @Autowired
    private OrderManagerMS orderManagerMS;

    public void calculateOrder(ChartPatternSignal pattern){
        double sl=0, tp=0, price=0;
        if(pattern.getMeta().getDirection() == 1){
            sl = pattern.getData().getPrediction().getPricehigh();
            tp = pattern.getData().getPrediction().getPricelow();
            price = pattern.getData().getPoints().getResistance().getY1();// + 10pp To Do function
        }
        else{
            tp = pattern.getData().getPrediction().getPricehigh();
            sl = pattern.getData().getPrediction().getPricelow();
            price = pattern.getData().getPoints().getResistance().getY1();// - 10pp To Do function
        }
        order = new Order("strategy",  "order_type",  sl,  tp,price, pattern.getInstrument());
        orderManagerMS.sendOrder(order);
    }
}
