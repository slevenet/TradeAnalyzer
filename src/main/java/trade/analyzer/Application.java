package trade.analyzer;

import com.oanda.v20.pricing_common.Price;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

//        SpringApplication.run(Application.class, args);

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        List<Price> priceList = new ArrayList<>();
        executorService.execute(new TradeDataPuller(priceList));
        executorService.shutdown();

    }
}
