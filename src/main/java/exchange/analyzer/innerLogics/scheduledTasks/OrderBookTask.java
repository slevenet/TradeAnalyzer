package exchange.analyzer.innerLogics.scheduledTasks;

import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.instrument.InstrumentOrderBookRequest;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.innerLogics.storages.OrderBookChartStorage;
import exchange.analyzer.model.OandaContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderBookTask {

    @Autowired
    private OandaContext oandaContext;
    @Autowired
    private OrderBookChartStorage storage;

    @Scheduled(fixedRate = 20 * ScheduleConstants.SECOND_FACTOR)
    public void pullOrderBook(){
        ScheduleConstants.currencies.forEach(currency ->
        {
            InstrumentName instrumentName = new InstrumentName(currency);
            InstrumentOrderBookRequest request = new InstrumentOrderBookRequest(instrumentName);

            try {
                storage.addOrderBook(oandaContext.getContext().instrument.orderBook(request).getOrderBook());
            } catch (RequestException | ExecuteException e) {
                e.printStackTrace();
            }
        });
    }
}
