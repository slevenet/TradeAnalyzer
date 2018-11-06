package exchange.analyzer.scheduledTasks;

import exchange.analyzer.configuration.common.constants.Constants;
import exchange.analyzer.model.autochartist.PatternRequest;
import exchange.analyzer.model.autochartist.keylevel.KLPattern;
import exchange.analyzer.storages.pattern.KeyLevelStorage;
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
public class KeyLevelTask {

	private static final Logger logger = LoggerFactory.getLogger(KeyLevelTask.class);

	private RestTemplate restTemplate   = new RestTemplate();
	private HttpHeaders httpHeaders     = new HttpHeaders();

	private KeyLevelStorage patternStorage;

	@Autowired
	public KeyLevelTask(KeyLevelStorage patternStorage) {
		this.patternStorage = patternStorage;
		httpHeaders.set("Authorization", Constants.AUTHORIZATION);
	}

//	@Scheduled(fixedRate = 15 * ScheduleConstants.SECOND_FACTOR)
	public void process() {
		PatternRequest request = new PatternRequest
				.Builder()
				.type("keylevel")
				.build();

		patternStorage.addPatterns(restTemplate.exchange(
				request.toString(),
				HttpMethod.GET,
				new HttpEntity<KLPattern>(httpHeaders),
				KLPattern.class).getBody());
	}
}
