package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.InstrumentNameOperations;
import exchange.analyzer.entity.InstrumentNameEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Repository
@Transactional
public class InstrumentNameOperationsImpl implements InstrumentNameOperations{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Integer persist(InstrumentNameEntity instrumentNameEntity) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createNativeQuery("SELECT id FROM instruments WHERE name = :name");
		query.setParameter("name", instrumentNameEntity.getName());

		Integer id = (Integer) query.getSingleResult();

		System.out.println("----- " + instrumentNameEntity.getName() + " : " + id);

		return id == null ? (Integer) session.save(instrumentNameEntity) : id;
	}
}
