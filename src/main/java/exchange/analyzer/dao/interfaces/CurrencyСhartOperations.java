package exchange.analyzer.dao.interfaces;

import java.util.List;

public interface CurrencyСhartOperations {
     List<Double> getSupportLines();
     List<Double> getResistLines();
}
