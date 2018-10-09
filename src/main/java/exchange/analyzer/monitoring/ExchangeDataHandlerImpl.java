package exchange.analyzer.monitoring;

import exchange.analyzer.monitoring.pullers.candles.CandlePullerImpl;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

public class ExchangeDataHandlerImpl implements ExchangeDataHandler {

    private static final Logger logger = Logger.getLogger(ExchangeDataHandlerImpl.class);

    @Override
    public void start(){
        logger.debug("START EXCHANGE DATA HANDLING");

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetail jobDetail = newJob(CandlePullerImpl.class)
                    .withIdentity(CANDLE_JOB, CANDLE_GROUP)
                    .build();
            Trigger trigger = newTrigger()
                    .withIdentity(CANDLE_TRIGGER, CANDLE_GROUP)
                    .startNow()
                    .withSchedule(cronSchedule(CANDLE_JOB_CRON_SCHEDULE))
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

//        ExecutorService executorService = Executors.newFixedThreadPool(1);

//        executorService.execute(new CandlePullerImpl(context));
//        executorService.execute(new TradeDataPuller(context));

    }
}
