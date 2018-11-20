package exchange.analyzer.utils;

import exchange.analyzer.entity.autochartist.chartpattern.*;
import exchange.analyzer.model.autochartist.chartpattern.ChartPatternSignal;


public class ConvertorFromModelToEntity {

    public static Signal getPatternEntity(ChartPatternSignal chartPatternSignal){

        Scores scoresEntity = new Scores(chartPatternSignal.getId(),
                chartPatternSignal.getMeta().getScores().getClarity(),
                chartPatternSignal.getMeta().getScores().getInitialtrend(),
                chartPatternSignal.getMeta().getScores().getBreakout(),
                chartPatternSignal.getMeta().getScores().getQuality(),
                chartPatternSignal.getMeta().getScores().getUniformity());

        Prediction predictionEntity = new Prediction(chartPatternSignal.getId(),
                chartPatternSignal.getData().getPrediction().getPricelow(),
                chartPatternSignal.getData().getPrediction().getPricehigh(),
                chartPatternSignal.getData().getPrediction().getTimefrom(),
                chartPatternSignal.getData().getPrediction().getTimeto());

        Meta metaEntity = new Meta(chartPatternSignal.getId(),
                scoresEntity,
                chartPatternSignal.getMeta().getProbability(),
                chartPatternSignal.getMeta().getInterval(),
                chartPatternSignal.getMeta().getDirection(),
                chartPatternSignal.getMeta().getLength(),
                chartPatternSignal.getMeta().getPattern(),
                chartPatternSignal.getMeta().getTrendtype(),
                chartPatternSignal.getMeta().isCompleted());

        Points pointEntity = new Points(chartPatternSignal.getId(),
                chartPatternSignal.getData().getPoints().getSupport().getY1(),
                chartPatternSignal.getData().getPoints().getSupport().getY0(),
                chartPatternSignal.getData().getPoints().getSupport().getX0(),
                chartPatternSignal.getData().getPoints().getSupport().getX1(),
                chartPatternSignal.getData().getPoints().getResistance().getY1(),
                chartPatternSignal.getData().getPoints().getResistance().getY0(),
                chartPatternSignal.getData().getPoints().getResistance().getX0(),
                chartPatternSignal.getData().getPoints().getResistance().getX1());

        Data dataEntity = new Data(chartPatternSignal.getId(),
                predictionEntity,
                pointEntity,
                chartPatternSignal.getData().getPatternendtime());

        Signal patternEntity = new Signal(chartPatternSignal.getInstrument(),
                dataEntity,
                chartPatternSignal.getType(),
                chartPatternSignal.getId(),
                metaEntity);

        return patternEntity;
    }

}
