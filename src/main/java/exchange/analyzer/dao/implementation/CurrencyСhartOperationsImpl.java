package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.CurrencyСhartOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyСhartOperationsImpl implements CurrencyСhartOperations {
    @Override
    public List<Double> getSupportLines() {
        return null;
    }

    @Override
    public List<Double> getResistLines() {
        return null;
    }
}
