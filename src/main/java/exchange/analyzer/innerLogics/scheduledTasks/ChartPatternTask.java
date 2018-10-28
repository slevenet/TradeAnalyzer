package exchange.analyzer.innerLogics.scheduledTasks;

import exchange.analyzer.innerLogics.scheduledTasks.abstracts.OandaTask;
import exchange.analyzer.innerLogics.storages.ChartPatternStorage;
import exchange.analyzer.model.autochartist.ChartPattern;
import exchange.analyzer.model.autochartist.ChartPatternRequest;
import org.apache.http.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChartPatternTask extends OandaTask{

    private static final Logger logger = LoggerFactory.getLogger(ChartPatternTask.class);

    @Autowired
    private ChartPatternStorage patternStorage;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    @Scheduled(fixedRate = 10 * ScheduleConstants.SECOND_FACTOR)
    public void process() {

        ScheduleConstants.CURRENCIES.forEach(currency ->
        {
            ScheduleConstants.PATTERN_PERIODS.forEach(period ->
            {
                ChartPatternRequest request = new ChartPatternRequest.Builder()
                        .instrument(currency)
                        .period(period)
                        .build();

                // todo: fix the way to set authorization
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.set("Authorization",
                        "Bearer 42358b5440b084e5a6ff8ec540e3b998-65eed9e2dca8ffe6b3b7008dcb4f4781");

                ChartPattern pattern = restTemplate.exchange(
                        request.toString(),
                        HttpMethod.GET,
                        new HttpEntity<ChartPattern>(httpHeaders),
                        ChartPattern.class).getBody();

                System.out.println("_____________PATTERNS______________");
                pattern.getSignals().forEach(sign ->
                {
                    System.out.println(sign.getInstrument() + sign.getData().toString());
                });
                patternStorage.addPatterns(pattern);
            });
        });
    }
}
