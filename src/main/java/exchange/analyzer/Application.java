package exchange.analyzer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import exchange.analyzer.analytics.ExchangeDataAnalyzer;
import exchange.analyzer.monitoring.ExchangeDataHandlerImpl;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

      //  SpringApplication.run(Application.class, args);

        ExchangeDataHandlerImpl exchangeDataHandlerImpl = new ExchangeDataHandlerImpl();
        exchangeDataHandlerImpl.start();

        ExchangeDataAnalyzer exchangeDataAnalyzer = new ExchangeDataAnalyzer();

    }
}
