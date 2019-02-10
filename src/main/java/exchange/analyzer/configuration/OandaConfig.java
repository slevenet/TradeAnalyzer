package exchange.analyzer.configuration;

import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import exchange.analyzer.configuration.common.constants.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OandaConfig {

    @Bean
    public Context context() {
        return new ContextBuilder(Constants.URI)
                .setApplication(Constants.APPLICATION)
                .setToken(Constants.TOKEN)
                .build();
    }
}
