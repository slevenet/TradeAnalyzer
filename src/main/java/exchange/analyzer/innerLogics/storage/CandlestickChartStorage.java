package exchange.analyzer.innerLogics.storage;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.model.CandlestickChartModel;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CandlestickChartStorage {

    private static Map<String, CandlestickChartModel> candlestickChartModels;

    public CandlestickChartStorage() {
        candlestickChartModels = new HashMap<>();
    }

    public void addChart(CandlestickChartModel chartModel) {

        String key = createKey(chartModel.getInstrumentName(), chartModel.getGranularity());
        candlestickChartModels.put(key, chartModel);
    }

    public void addChart(InstrumentName instrumentName, CandlestickGranularity granularity, List<Candlestick> candlesticks) {

        String key = createKey(instrumentName, granularity);
        if (candlestickChartModels.containsKey(key)) {
            candlestickChartModels.get(key).addCandlesticks(candlesticks);
            return;
        }

        candlestickChartModels.put(key, new CandlestickChartModel(instrumentName, granularity, candlesticks));
    }

    public DateTime getLastTimestamp(InstrumentName instrumentName, CandlestickGranularity granularity)
    {
        if (candlestickChartModels == null || candlestickChartModels.isEmpty())
            return null;

        String key = createKey(instrumentName, granularity);

        return candlestickChartModels.containsKey(key)
                ? candlestickChartModels.get(key).getLastTimestamp()
                : null;
    }

    private String createKey(InstrumentName instrumentName, CandlestickGranularity granularity)
    {
        return instrumentName + "_" + granularity;
    }
}
