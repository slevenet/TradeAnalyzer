package exchange.analyzer.calculations.orderBook;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import com.oanda.v20.primitives.StringPrimitive;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

@JsonComponent
public class OrderBookChartJsonSerializer extends JsonSerializer<OrderBookChart> {

	@Override
	public void serialize(OrderBookChart orderBookChart,
						  JsonGenerator jsonGenerator,
						  SerializerProvider serializerProvider) throws IOException {

		jsonGenerator.writeStartObject();

		jsonGenerator.writeStringField("instrumentName", orderBookChart.getInstrumentName().toString());

		OrderBook book = orderBookChart.getOrderBookMap()
				.get(orderBookChart.getOrderBookMap().keySet()
						.stream()
						.sorted(Comparator.comparing(StringPrimitive::toString))
						.reduce((a, b) -> b)
						.get());
		jsonGenerator.writeObjectField("orderBook", book);

		jsonGenerator.writeEndObject();
	}
}
