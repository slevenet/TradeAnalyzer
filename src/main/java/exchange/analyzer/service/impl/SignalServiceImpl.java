package exchange.analyzer.service.impl;


import exchange.analyzer.Util;
import exchange.analyzer.calculations.CalculateOrder;
import exchange.analyzer.entity.autochartist.chartpattern.Signal;
import exchange.analyzer.model.charts.ChartPatternModel;
import exchange.analyzer.repository.SignalRepository;
import exchange.analyzer.service.SignalService;
import exchange.analyzer.utils.ConvertorFromModelToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalServiceImpl implements SignalService {

    @Autowired
    SignalRepository signalRepository;

    @Override
    public void addSignal(Signal signal){
        if(signalRepository.getOne(signal.getId()) == null)
            signalRepository.saveAndFlush(signal);
    }

    @Override
    public void addSignal(ChartPatternModel chartPattern) {

    }

    @Override
    public void addSignal(ChartPattern chartPattern) {
        chartPattern.getSignals().forEach(signal -> {
            if (Util.isSupportedInstrument(signal.getInstrument())) {
                signalRepository.saveAndFlush(ConvertorFromModelToEntity.getPatternEntity((ChartPatternSignal) chartPattern));
                addSignal(signal);
            }
        }); 
    }

    public <S extends exchange.analyzer.model.autochartist.Signal> void addPattern(S pattern) {
        if (sessionFactory.getCurrentSession().get(Signal.class, pattern.getId())== null) {
            sessionFactory.getCurrentSession().save(ConvertorFromModelToEntity.getPatternEntity((ChartPatternSignal) pattern));
            CalculateOrder.calculateOrder((ChartPatternSignal) pattern);
        }
    }

    private void addSignal(ChartPatternSignal signal) {
    }
}
