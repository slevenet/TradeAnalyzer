package exchange.analyzer.monitoring.pullers.trades;

import exchange.analyzer.monitoring.pullers.abstraction.UnscheduledDataPuller;
import org.apache.log4j.Logger;

public class TradeDataPuller extends UnscheduledDataPuller {
    private static Logger logger = Logger.getLogger(TradeDataPuller.class);

    @Override
    public void run() {

        logger.debug("START PRICE PULLING");

        try {
            pullData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.debug("END PRICE PULLING");
    }

    protected void pullData() throws Exception {

//        context.trade
    }
}
