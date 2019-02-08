package exchange.analyzer.repository;

import exchange.analyzer.entity.Signals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalsRepository extends JpaRepository<Signals, Long> {
}


