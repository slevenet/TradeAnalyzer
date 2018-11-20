package exchange.analyzer.calculations.orderBook;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import exchange.analyzer.model.charts.OrderBookChart;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Map;

@JsonComponent
public class OrderBookChartJsonSerializer extends JsonSerializer<OrderBookChart> {

	@Override
	public void serialize(OrderBookChart orderBookChart,
						  JsonGenerator jsonGenerator,
						  SerializerProvider serializerProvider) throws IOException {

		System.out.println("-0)_9-()_)(-))(_)9_()");
		jsonGenerator.writeStartObject();

		jsonGenerator.writeStringField("instrumentName", orderBookChart.getInstrumentName().toString());

		jsonGenerator.writeObjectFieldStart("orderBooks");
		for (Map.Entry<DateTime, OrderBook> entry : orderBookChart.getOrderBookMap().entrySet()) {
			jsonGenerator.writeObjectField(entry.getKey().toString(), entry.getValue());
		}
		jsonGenerator.writeEndObject();

		jsonGenerator.writeEndObject();
		jsonGenerator.close();
	}
}
