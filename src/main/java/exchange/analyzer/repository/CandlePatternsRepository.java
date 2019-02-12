package exchange.analyzer.repository;

import exchange.analyzer.entity.CandlePatterns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandlePatternsRepository extends JpaRepository<CandlePatterns, Long> {
}
