package exchange.analyzer.model;

import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import exchange.analyzer.constants.Constants;
import org.springframework.stereotype.Component;

@Component
public class OandaContext {
    private final Context context = new ContextBuilder(Constants.URI)
            .setApplication(Constants.APPLICATION)
            .setToken(Constants.TOKEN)
            .build();

    public Context getContext() {
        return context;
    }

}
