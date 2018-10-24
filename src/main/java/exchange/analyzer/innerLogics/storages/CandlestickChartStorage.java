package exchange.analyzer.innerLogics.storages;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.calculations.candlestick.Events;
import exchange.analyzer.innerLogics.calculations.candlestick.NotificationListener;
import exchange.analyzer.innerLogics.keyManager.KeyManager;
import exchange.analyzer.model.CandlestickChart;
import exchange.analyzer.innerLogics.keyManager.CurrencyKey;
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
        CurrencyKey key = KeyManager.getKey(instrumentName, granularity);
        candlestickChart.addCandlestickMap(key,candlesticks);
    }

    public DateTime getLastTimestamp(InstrumentName instrumentName, CandlestickGranularity granularity) {

        return candlestickChart.getLastTimestamp(instrumentName, granularity);
    }

    @PostConstruct
    private void observable(){
        candlestickChart.events.subscribe(Events.UPDATE, notificationListener);
    }
}
