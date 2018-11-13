package exchange.analyzer.scheduledTasks;

import exchange.analyzer.configuration.common.constants.Constants;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.dao.services.AutochartistOperationsDBService;
import exchange.analyzer.entity.autochartist.chartpattern.Signal;
import exchange.analyzer.storages.pattern.ChartPatternStorage;
import exchange.analyzer.model.autochartist.chartpattern.ChartPattern;
import exchange.analyzer.model.autochartist.PatternRequest;
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

    private RestTemplate restTemplate   = new RestTemplate();
    private HttpHeaders httpHeaders     = new HttpHeaders();

    private ChartPatternStorage patternStorage;
    @Autowired
    private AutochartistOperationsDBService autochartistOperationsDBService;

    @Autowired
    public ChartPatternTask(ChartPatternStorage patternStorage) {
        this.patternStorage = patternStorage;
        httpHeaders.set("Authorization", Constants.AUTHORIZATION);
    }

    @Scheduled(fixedRate = 15 * ScheduleConstants.SECOND_FACTOR)
    public void process() {
        PatternRequest request = new PatternRequest
                .Builder()
                .type("chartpattern")
                .build();

        patternStorage.addPatterns(restTemplate.exchange(
                        request.toString(),
                        HttpMethod.GET,
                        new HttpEntity<ChartPattern>(httpHeaders),
                        ChartPattern.class).getBody());

      //  autochartistOperationsDBService.addPattern();
        autochartistOperationsDBService.addPattern();
    }
}
