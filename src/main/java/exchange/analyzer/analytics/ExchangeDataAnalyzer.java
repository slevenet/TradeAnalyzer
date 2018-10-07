package exchange.analyzer.analytics;

import org.apache.log4j.Logger;
import exchange.analyzer.monitoring.ExchangeDataHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeDataAnalyzer {

    private static final Logger logger = Logger.getLogger(ExchangeDataHandler.class);

    public void start(){
        logger.debug("START ANALYZER");

        ExecutorService executorService = Executors.newFixedThreadPool(1);

    }
}
