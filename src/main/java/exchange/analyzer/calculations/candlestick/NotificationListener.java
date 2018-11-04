package exchange.analyzer.calculations.candlestick;

import exchange.analyzer.calculations.candlestick.abstracts.CandlestickClassifier;
import exchange.analyzer.calculations.candlestick.interfaces.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class NotificationListener implements EventListener {

    @Autowired
    List<CandlestickClassifier> candlestickClassifierList;

    @PostConstruct
    private void linkedObs(){
        for(int i = 0; i < candlestickClassifierList.size() - 1 ; i++)
            candlestickClassifierList.get(i).linkWith(candlestickClassifierList.get(i + 1));
    }

    @Override
    public void update(String eventType) {
        System.out.println("Has been changed");
        //candlestickClassifierList.get(0).check()
    }
}
