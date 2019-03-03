package exchange.analyzer.shedulers;

import com.oanda.v20.Context;
import exchange.analyzer.utils.OandaComponent;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Sheduler {
    @Autowired
    protected Context context;

    @Autowired
    protected OandaComponent oandaComponent;

    abstract protected void process();
}
