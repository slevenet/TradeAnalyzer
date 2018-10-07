package trade.analyzer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oanda.v20.pricing.PricingHeartbeat;
import com.oanda.v20.pricing_common.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class TradeDataPuller implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(TradeDataPuller.class);

    private List<Price> prices;

    public TradeDataPuller(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public void run() {

        logger.debug("START PRICE PULLING");

        try {
            pullData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.debug("END PRICE PULLING");
    }

    private void pullData() throws IOException {

        HttpURLConnection connection = createConnection();

        int status = connection.getResponseCode();
        logger.info("__CODE:__" + status);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        String inputLine;
        int i = 0;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine + "\n__________\n");
            prices.add(gson.fromJson(inputLine, Price.class));
            System.out.println(prices.get(i++));
        }
        in.close();
    }

    private HttpURLConnection createConnection() throws IOException {

        URL url = new URL("https://stream-fxpractice.oanda.com/v3/accounts/101-004-9452424-001/pricing/stream?instruments=EUR_USD");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer 42358b5440b084e5a6ff8ec540e3b998-65eed9e2dca8ffe6b3b7008dcb4f4781");
        connection.setConnectTimeout(20000);
        connection.setReadTimeout(20000);

        return connection;
    }
}
