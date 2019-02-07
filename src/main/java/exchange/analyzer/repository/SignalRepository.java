package exchange.analyzer.repository;

import exchange.analyzer.entity.Signal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalRepository extends JpaRepository<Signal, Long> {
}
