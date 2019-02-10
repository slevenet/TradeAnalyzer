package exchange.analyzer.shedulers;

import com.oanda.v20.Context;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Sheduler {
    @Autowired
    protected Context context;

    abstract protected void process();
}
