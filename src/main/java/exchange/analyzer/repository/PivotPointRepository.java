package exchange.analyzer.repository;

import exchange.analyzer.entity.PivotPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PivotPointRepository extends JpaRepository<PivotPointEntity, Long> {
}
