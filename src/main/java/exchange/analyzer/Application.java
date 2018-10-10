package exchange.analyzer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import exchange.analyzer.pullers.ExchangeDataHandlerImpl;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

      //  SpringApplication.run(Application.class, args);

        ExchangeDataHandlerImpl exchangeDataHandlerImpl = new ExchangeDataHandlerImpl();
        exchangeDataHandlerImpl.start();


    }
}
