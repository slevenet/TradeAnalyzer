package exchange.analyzer.monitoring.pullers;

import com.oanda.v20.Context;
import database.DatabaseStorage;

public abstract class DataPuller implements Runnable {

    protected final Context context;
    protected final DatabaseStorage databaseStorage = DatabaseStorage.getInstance();

    public DataPuller(Context context) {
        this.context = context;
    }

    protected abstract void pullData() throws Exception;
}
