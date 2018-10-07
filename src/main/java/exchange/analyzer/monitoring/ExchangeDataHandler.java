package exchange.analyzer.monitoring;

import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import org.apache.log4j.Logger;
import exchange.analyzer.monitoring.pullers.CandlesPuller;
import exchange.analyzer.monitoring.pullers.TradeDataPuller;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeDataHandler {

    private static final Logger logger = Logger.getLogger(ExchangeDataHandler.class);

    public void start(){
        logger.debug("START EXCHANGE DATA HANDLING");

        Context context = new ContextBuilder("https://api-fxpractice.oanda.com")
                .setApplication("json")
                .setToken("42358b5440b084e5a6ff8ec540e3b998-65eed9e2dca8ffe6b3b7008dcb4f4781")
                .build();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(new CandlesPuller(context));
        executorService.execute(new TradeDataPuller(context));

        executorService.shutdown();
    }
}
