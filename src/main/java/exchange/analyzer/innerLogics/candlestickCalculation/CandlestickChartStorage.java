package exchange.analyzer.innerLogics.candlestickCalculation;

import com.oanda.v20.instrument.Candlestick;
import com.oanda.v20.instrument.CandlestickGranularity;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.model.CandlestickChartModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandlestickChartStorage {

    private static List<CandlestickChartModel> candlestickChartModels;

    public void addChart(CandlestickChartModel chartModel) {

        candlestickChartModels.add(chartModel);
    }

    public void addChart(InstrumentName instrumentName, CandlestickGranularity granularity, List<Candlestick> candlesticks) {

        for (CandlestickChartModel chartModel : candlestickChartModels) {
            if (chartModel.getInstrumentName().equals(instrumentName) && chartModel.getGranularity().equals(granularity)) {
                chartModel.getCandlestickList().addAll(candlesticks);
                return;
            }
        }

        candlestickChartModels.add(new CandlestickChartModel(instrumentName, granularity, candlesticks));
    }

    public DateTime getLastTimestamp(InstrumentName instrumentName, CandlestickGranularity granularity)
    {
        if (candlestickChartModels == null || candlestickChartModels.isEmpty())
            return null;

       /* cand lestickChartModels.stream()
                .filter(c -> c.getInstrumentName().equals(instrumentName) && c.getGranularity().equals(granularity));
for*/
        for (CandlestickChartModel chartModel : candlestickChartModels) {
            if (chartModel.getInstrumentName().equals(instrumentName) && chartModel.getGranularity().equals(granularity)) {
                List<Candlestick> candlesticks = chartModel.getCandlestickList();
                return candlesticks.get(candlesticks.size() - 1).getTime();
            }
        }

        return null;
    }

    private void def(){

    }
}