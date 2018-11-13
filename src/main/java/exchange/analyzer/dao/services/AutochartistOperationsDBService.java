package exchange.analyzer.dao.services;


//import exchange.analyzer.model.autochartist.chartpattern.Signal;
import exchange.analyzer.entity.autochartist.chartpattern.Signal;
import exchange.analyzer.tests.MockiSignal;
import exchange.analyzer.utils.ConvertorFromModelToEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AutochartistOperationsDBService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ConvertorFromModelToEntity convertorFromModelToEntity;

    // MANDATORY: Transaction must be created before.
    public void addPattern()  {
        sessionFactory.getCurrentSession().save(new MockiSignal().getTest());

    }

    public Signal getS(){
        long id = 1;
       return sessionFactory.getCurrentSession().get(Signal.class, id);
    }
}
