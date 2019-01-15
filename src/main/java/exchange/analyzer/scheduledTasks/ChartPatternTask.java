package exchange.analyzer.scheduledTasks;

import com.google.gson.GsonBuilder;
import exchange.analyzer.configuration.common.constants.Constants;
import exchange.analyzer.configuration.common.constants.ScheduleConstants;
import exchange.analyzer.model.ChartPatternModelDeserializerFromJSON;
import exchange.analyzer.model.charts.ChartPatternModel;
import exchange.analyzer.service.impl.SignalServiceImpl;
import exchange.analyzer.configuration.common.PatternRequest;
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
    private SignalServiceImpl signalService;

    private RestTemplate restTemplate   = new RestTemplate();
    private HttpHeaders httpHeaders     = new HttpHeaders();

    public ChartPatternTask() {
        httpHeaders.set("Authorization", Constants.AUTHORIZATION);
    }

    @Scheduled(fixedRate = 15 * ScheduleConstants.MINUTE_FACTOR)
    public void process() {
        PatternRequest request = new PatternRequest
                .Builder()
                .type("chartpattern")
                .build();

        GsonBuilder jsonbuilder = new GsonBuilder()
                .registerTypeAdapter(ChartPatternModel.class, new ChartPatternModelDeserializerFromJSON());

        signalService.addSignal(jsonbuilder.create().fromJson(restTemplate.exchange(
                request.toString(),
                HttpMethod.GET,
                new HttpEntity<ChartPatternModel>(httpHeaders),
                String.class).getBody() , ChartPatternModel.class));
    }
}
