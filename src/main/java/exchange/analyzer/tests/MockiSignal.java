package exchange.analyzer.tests;

import exchange.analyzer.entity.autochartist.chartpattern.*;

import java.awt.*;

public class MockiSignal {

    Scores sc = new Scores(3, 1, 1, 1, 1, 1);
    Prediction pr =new Prediction(3,2.0, 2.0, 2, 2);
    Meta meta = new Meta(3, sc, 3.0, 3, 3, 3, "pattern", "meta", true);
    Points point = new Points(3, 4.0, 4.0, 4, 4, 4.0, 4.0, 4, 4);
    Data data = new Data(3, pr, point, 5);
    Signal signal = new Signal("USD", data, "type", 3, meta);

    public Signal getTest(){
        return signal;
    }
}
