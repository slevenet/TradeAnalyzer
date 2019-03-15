package exchange.analyzer.service.impl;

import exchange.analyzer.entity.PivotPointEntity;
import exchange.analyzer.repository.PivotPointRepository;
import exchange.analyzer.service.PivotPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PivotPointImpl implements PivotPointService {

    @Autowired
    PivotPointRepository pivotPointRepository;

    @Override
    public PivotPointEntity getByID(Long id) {
        return pivotPointRepository.getOne(id);
    }

    public List<PivotPointEntity> getAll(){
        return pivotPointRepository.findAll();
    }

    public void insert(PivotPointEntity pivotPointEntity){
        pivotPointRepository.save(pivotPointEntity);
    }
}
