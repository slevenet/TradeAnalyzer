package exchange.analyzer;

public interface Constants {

     interface ExchangeDataHandler {

         String
                CANDLE_JOB = "CandleJob",
                CANDLE_GROUP = "CandleGroup",
                CANDLE_TRIGGER = "CandleTrigger";
         String
                CANDLE_JOB_CRON_SCHEDULE = "0 5/20 * * * ?"; // every 20 minutes starting from 5th

    }
}
