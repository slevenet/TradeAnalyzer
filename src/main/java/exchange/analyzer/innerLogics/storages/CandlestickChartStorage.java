package exchange.analyzer.innerLogics.storages;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.calculations.candlestick.Events;
import exchange.analyzer.innerLogics.calculations.candlestick.NotificationListener;
import exchange.analyzer.model.CandlestickChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CandlestickChartStorage {

    @Autowired
    private CandlestickChart candlestickChart;
    @Autowired
    private NotificationListener notificationListener;

    public void addChart(InstrumentName instrumentName,
                         CandlestickGranularity granularity,
                         List<Candlestick> candlesticks) {
        String key = createKey(instrumentName, granularity);
        candlestickChart.addCandlestickMap(key,candlesticks);
    }

    public DateTime getLastTimestamp(InstrumentName instrumentName, CandlestickGranularity granularity) {
        if (candlestickChart.getCandlestickMap() == null)
            return null;

        return candlestickChart.getCandlestickMap().containsKey(createKey(instrumentName, granularity))
                ? candlestickChart.getLastTimestamp()
                : null;
    }

    //The structure of key is EUR_USD_M15(example)
    private String createKey(InstrumentName instrumentName, CandlestickGranularity granularity) {
        return instrumentName + "_" + granularity;
    }

    @PostConstruct
    private void observable(){
        candlestickChart.events.subscribe(Events.UPDATE, notificationListener);
    }
}
