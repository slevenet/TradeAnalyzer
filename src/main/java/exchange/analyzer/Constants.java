package exchange.analyzer;

public interface Constants {
     interface CandlePuller{
        String  EUR_USD = "EUR_USD";
        String TIME_M15 = "M15";
        String TIME_H1 = "H1";
        String TIME_H4 = "H4";
        String TIME_D = "D";

    }

     interface ExchangeDataHandler {

         String
                CANDLE_JOB = "CandleJob",
                CANDLE_GROUP = "CandleGroup",
                CANDLE_TRIGGER = "CandleTrigger";
        String
                CANDLE_JOB_CRON_SCHEDULE = "0 1/1 * * * ?"; // every 20 minutes starting from 5th

    }
}
