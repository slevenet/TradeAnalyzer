package exchange.analyzer.monitoring.pullers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oanda.v20.Context;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TradeDataPuller extends DataPuller {
    private static Logger logger = Logger.getLogger(TradeDataPuller.class);

    public TradeDataPuller(Context context) {
        super(context);
    }

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
