package exchange.analyzer.dao.services;

import exchange.analyzer.dao.implementation.AutochartistOperationsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutochartistOperationsService {

    @Autowired
    AutochartistOperationsImpl autochartistOperations;
}
