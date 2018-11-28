package exchange.analyzer.dao.services;

import com.oanda.v20.primitives.InstrumentName;
import exchange.analyzer.dao.implementation.InstrumentNameOperationsImpl;
import exchange.analyzer.entity.InstrumentNameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentNameOperationsService {

	@Autowired
	private InstrumentNameOperationsImpl instrumentNameOperations;

	public Integer persist(InstrumentName instrumentName) {
		InstrumentNameEntity entity = new InstrumentNameEntity(instrumentName.toString());

		return instrumentNameOperations.persist(entity);
	}
}
