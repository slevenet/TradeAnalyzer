package exchange.analyzer.innerLogics.scheduledTasks;

import exchange.analyzer.constants.ScheduleConstants;
import exchange.analyzer.innerLogics.storages.ChartPatternStorage;
import exchange.analyzer.model.autochartist.ChartPattern;
import exchange.analyzer.model.autochartist.ChartPatternRequest;
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
public class ChartPatternTask {

    private static final Logger logger = LoggerFactory.getLogger(ChartPatternTask.class);

    @Autowired
    private ChartPatternStorage patternStorage;

    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 15 * ScheduleConstants.SECOND_FACTOR)
    public void process() {
       ChartPatternRequest request = new ChartPatternRequest.Builder().build();

                // todo: fix the way to set authorization
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.set("Authorization",
                        "Bearer 42358b5440b084e5a6ff8ec540e3b998-65eed9e2dca8ffe6b3b7008dcb4f4781");

        patternStorage.addPatterns(restTemplate.exchange(
                        request.toString(),
                        HttpMethod.GET,
                        new HttpEntity<ChartPattern>(httpHeaders),
                        ChartPattern.class).getBody());

    }
}
