package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.OrderBookAnalyzeInfoOperations;
import exchange.analyzer.entity.OrderAnalyzeInfoEntity;
import exchange.analyzer.entity.OrderAnalyzeInfoId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderBookAnalyzeInfoOperationsImpl implements OrderBookAnalyzeInfoOperations {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persist(OrderAnalyzeInfoEntity analyzeInfoEntity) {
		Session session = sessionFactory.getCurrentSession();

		session.persist(analyzeInfoEntity);
	}

	@Override
	public OrderAnalyzeInfoEntity load(OrderAnalyzeInfoId id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(OrderAnalyzeInfoEntity.class, id);
	}
}
