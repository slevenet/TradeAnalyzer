package exchange.analyzer.dao.services;


import exchange.analyzer.model.autochartist.chartpattern.Signal;
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

    // MANDATORY: Transaction must be created before.
    public void addPattern(Signal signal)  {
        sessionFactory.getCurrentSession().save(signal);

    }
}
