package exchange.analyzer.scheduledTasks.abstracts;

import exchange.analyzer.scheduledTasks.interfaces.Task;
import exchange.analyzer.model.OandaContext;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OandaTask implements Task{

    @Autowired
    protected OandaContext oandaContext;
}