package exchange.analyzer.dao.services;

import exchange.analyzer.Constants;
import exchange.analyzer.dao.implementation.CurrencyСhartOperationsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyСhartOperationsService {

    @Autowired
    private CurrencyСhartOperationsImpl operations;

    public List<Double> getSupportLines(){
        return operations.getSupportLines();
    }
    public List<Double> getResistLines(){
        return  operations.getResistLines();
    }
}
