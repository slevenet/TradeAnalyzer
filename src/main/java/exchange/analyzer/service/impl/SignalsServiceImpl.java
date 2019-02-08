package exchange.analyzer.service.impl;




import exchange.analyzer.entity.Signals;
import exchange.analyzer.repository.SignalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalsServiceImpl  {

    @Autowired
    SignalsRepository signalsRepository;



    public void addSignal(Signals signal) {

    }


}
