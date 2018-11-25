package exchange.analyzer.storages;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.configuration.common.keyManager.KeyManager;
import exchange.analyzer.model.charts.CandlestickChart;
import exchange.analyzer.configuration.common.keyManager.CurrencyKey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandlestickChartStorage {


    //@Autowired
    //private NotificationListener notificationListener;

    private List<CandlestickChart> candlestickChartList = new ArrayList<>();

    public void addChart(InstrumentName instrument, CandlestickGranularity granularity, List<Candlestick> candlesticks) {

        if (isKey(KeyManager.getKey(instrument, granularity))) {
            setCandlesticksByKey(KeyManager.getKey(instrument, granularity), candlesticks);
        } else {
            candlestickChartList.add(new CandlestickChart(KeyManager.getKey(instrument, granularity), candlesticks));
        }
    }

    public List<CandlestickChart> getCandlestickChartList(){
        return candlestickChartList;
    }

    private boolean isKey(CurrencyKey key){
        return candlestickChartList.stream().anyMatch(element ->
                element.getKey().toString().equals(key.toString()));
    }

    private void setCandlesticksByKey(CurrencyKey key, List<Candlestick> value){
        candlestickChartList.stream()
                .filter(element -> element.getKey().equals(key))
                .peek(element -> element.setValue(value));
    }


   // @PostConstruct
  //  private void observable(){
  //      candlestickChart.events.subscribe(Events.UPDATE, notificationListener);
  //  }
}
