package exchange.analyzer.shedulers;


import exchange.analyzer.components.shedulers.Sheduler;
import exchange.analyzer.model.OandaContext;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OandaComponentSheduler implements Sheduler {

    @Autowired
    protected OandaContext oandaContext;
}