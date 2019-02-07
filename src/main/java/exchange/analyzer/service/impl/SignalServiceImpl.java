package exchange.analyzer.service.impl;



import exchange.analyzer.entity.Signal;
import exchange.analyzer.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalServiceImpl  {

    @Autowired
    SignalRepository signalRepository;



    public void addSignal(Signal signal) {

    }


}
