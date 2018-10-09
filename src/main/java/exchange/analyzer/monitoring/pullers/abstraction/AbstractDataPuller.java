package exchange.analyzer.monitoring.pullers.abstraction;

import com.oanda.v20.Context;
import com.oanda.v20.ContextBuilder;
import database.DatabaseStorage;
import exchange.analyzer.monitoring.pullers.DataPuller;

public abstract class AbstractDataPuller  implements DataPuller {

    protected static final Context context = new ContextBuilder(URI)
            .setApplication(APPLICATION)
            .setToken(TOKEN)
            .build();
    protected final DatabaseStorage databaseStorage = DatabaseStorage.getInstance();

    public AbstractDataPuller() {
    }

    protected abstract void pullData() throws Exception;
}
