package exchange.analyzer.dao.implementation;

import exchange.analyzer.dao.interfaces.CurrencyСhartOperations;
import exchange.analyzer.storages.CandlestickChartStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Component
public class CurrencyСhartOperationsImpl implements CurrencyСhartOperations {

    @Autowired
    CandlestickChartStorage candlestickChartStorage;

    @Override
    public List<Double> getSupportLines() {

        final Map<Double, List<Double>> collect = ThreadLocalRandom.current().doubles(0, 1)
                .limit(1000).mapToObj(d -> d)
                .collect(groupingBy(d -> Math.floor(d * 10) / 10, toList()));
        System.out.println(collect);


   //     Map<Integer, Long> map = candlestickChartStorage.getCandlestickChartList()
   //             .stream().map(index -> index.getValue().stream().collect(
   //             groupingBy(, Collectors.counting()));
        return null;
    }

    @Override
    public List<Double> getResistLines() {
        return null;
    }
}
