package exchange.analyzer.monitoring;

public interface ExchangeDataHandler {

    String
            CANDLE_JOB = "CandleJob",
            CANDLE_GROUP = "CandleGroup",
            CANDLE_TRIGGER = "CandleTrigger";
    String
            CANDLE_JOB_CRON_SCHEDULE = "0 1/1 * * * ?"; // every 20 minutes starting from 5th

    void start();
}
