package exchange.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import exchange.analyzer.analytics.ExchangeDataAnalyzer;
import exchange.analyzer.monitoring.ExchangeDataHandler;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

      //  SpringApplication.run(Application.class, args);

        ExchangeDataHandler exchangeDataHandler = new ExchangeDataHandler();
        exchangeDataHandler.start();

        ExchangeDataAnalyzer exchangeDataAnalyzer = new ExchangeDataAnalyzer();

    }
}
