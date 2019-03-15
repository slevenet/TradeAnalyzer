package exchange.analyzer.controller;

import exchange.analyzer.entity.PivotPointEntity;
import exchange.analyzer.service.impl.PivotPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api")
public class TradeAnalyzeEndPointController {

    @Autowired
    PivotPointImpl pivotPoint;

    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("pivotpoints")
    public List<PivotPointEntity> getAllPivotPoints(){
        return pivotPoint.getAll();
    }

}
