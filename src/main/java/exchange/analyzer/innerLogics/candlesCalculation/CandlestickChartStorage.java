package exchange.analyzer.innerLogics.candlesCalculation;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.model.CandlestickChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CandlestickChartStorage {

    @Autowired
   private  CandlestickChartModel candlestickChartModel;

    @Autowired
    private NotificationListener notificationListener;

    public void addChart(InstrumentName instrumentName, CandlestickGranularity granularity, List<Candlestick> candlesticks) {
        String key = createKey(instrumentName, granularity);
        candlestickChartModel.addCandlestickCharMap(key,candlesticks);
    }

    public DateTime getLastTimestamp(InstrumentName instrumentName, CandlestickGranularity granularity) {
        if (candlestickChartModel.getCandlestickCharMap() == null || candlestickChartModel.getCandlestickCharMap().isEmpty())
            return null;

        return candlestickChartModel.getCandlestickCharMap().containsKey(createKey(instrumentName, granularity))
                ? candlestickChartModel.getLastTimestamp()
                : null;
    }

    //The structure of key is EUR_USD_M15(example)
    private String createKey(InstrumentName instrumentName, CandlestickGranularity granularity) {
        return instrumentName + "_" + granularity;
    }

    @PostConstruct
    private void observable(){
        candlestickChartModel.events.subscribe("update", notificationListener);
    }
}
