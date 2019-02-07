/*
package exchange.analyzer.shedulers;

import com.oanda.v20.ExecuteException;
import com.oanda.v20.RequestException;
import com.oanda.v20.instrument.InstrumentOrderBookRequest;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.configuration.common.constants.BasicConstant;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderBookComponentSheduler extends OandaComponentSheduler {

    private static final Logger logger = LoggerFactory.getLogger(OrderBookComponentSheduler.class);

    @Autowired
    private OrderBookChartStorage storage;

    @Scheduled(fixedRate = 15 * ScheduleConstants.MINUTE_FACTOR)
    public void process(){
        BasicConstant.SUPPORTED_INSTRUMENT.forEach(currency ->
        {
            InstrumentName instrumentName       = new InstrumentName(currency);
            InstrumentOrderBookRequest request  = new InstrumentOrderBookRequest(instrumentName);

            try {
                storage.clearDate();
                OrderBook orderBook = oandaContext.getContext().instrument.orderBook(request).getOrderBook();
                storage.addOrderBook(orderBook);
            } catch (RequestException | ExecuteException e) {
                logger.error("Error during order book task", e);
            }
        });
    }
}
*/
