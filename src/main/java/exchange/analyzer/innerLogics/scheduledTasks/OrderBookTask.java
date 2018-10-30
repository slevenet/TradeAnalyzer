package exchange.analyzer.innerLogics.scheduledTasks;

import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.instrument.InstrumentOrderBookRequest;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.constants.ScheduleConstants;
import exchange.analyzer.innerLogics.scheduledTasks.abstracts.OandaTask;
import exchange.analyzer.innerLogics.storages.OrderBookChartStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBookTask extends OandaTask {

    private static final Logger logger = LoggerFactory.getLogger(OrderBookTask.class);

    @Autowired
    private OrderBookChartStorage storage;

//    @Scheduled(fixedRate = 20 * ScheduleConstants.SECOND_FACTOR)
    public void process(){
        ScheduleConstants.CURRENCIES.forEach(currency ->
        {
            InstrumentName instrumentName       = new InstrumentName(currency);
            InstrumentOrderBookRequest request  = new InstrumentOrderBookRequest(instrumentName);

            try {
                OrderBook orderBook = oandaContext.getContext().instrument.orderBook(request).getOrderBook();
                storage.addOrderBook(orderBook);
            } catch (RequestException | ExecuteException e) {
                logger.error("Error during order book task", e);
            }
        });
    }
}
