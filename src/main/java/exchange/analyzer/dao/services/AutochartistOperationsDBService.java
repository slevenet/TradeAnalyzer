package exchange.analyzer.dao.services;


//import exchange.analyzer.model.autochartist.chartpattern.Signal;
import exchange.analyzer.calculations.CalculateOrder;
import exchange.analyzer.entity.autochartist.chartpattern.Signal;
import exchange.analyzer.model.autochartist.chartpattern.ChartPattern;
import exchange.analyzer.model.autochartist.chartpattern.ChartPatternSignal;
import exchange.analyzer.utils.ConvertorFromModelToEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;

@Repository
@Transactional
public class AutochartistOperationsDBService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CalculateOrder CalculateOrder;

    // MANDATORY: Transaction must be created before.

    public Signal getS(){
        long id = 1;
       return sessionFactory.getCurrentSession().get(Signal.class, id);
    }

    public void addPattern(ChartPattern chartPattern){
        chartPattern.getSignals().forEach(s -> {
            if(sessionFactory.getCurrentSession().get(Signal.class, s.getId())== null)
                sessionFactory.getCurrentSession().save(ConvertorFromModelToEntity.getPatternEntity(s));
        });
    }

    public <S extends exchange.analyzer.model.autochartist.Signal> void addPattern(S pattern) {
        if (sessionFactory.getCurrentSession().get(Signal.class, pattern.getId())== null) {
            sessionFactory.getCurrentSession().save(ConvertorFromModelToEntity.getPatternEntity((ChartPatternSignal) pattern));
            CalculateOrder.calculateOrder((ChartPatternSignal) pattern);
        }
    }
}
