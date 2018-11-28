package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.OrderBookChartOperations;
import exchange.analyzer.entity.OrderBookChartEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderBookChartOperationsImpl implements OrderBookChartOperations {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persist(OrderBookChartEntity orderBookChart) {

		Session session = sessionFactory.getCurrentSession();

		session.persist(orderBookChart);
	}

	@Override
	public Integer save(OrderBookChartEntity orderBookChart) {

		Session session = sessionFactory.getCurrentSession();

		return (Integer) session.save(orderBookChart);
	}

	@Override
	public OrderBookChartEntity load(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		OrderBookChartEntity chart = session.get(OrderBookChartEntity.class, id);

		return chart;
	}

	@Override
	public OrderBookChartEntity loadByNaturalId(Integer instrumentNameId) {
		Session session = sessionFactory.getCurrentSession();

		return session.bySimpleNaturalId(OrderBookChartEntity.class).load(instrumentNameId);
	}
}
