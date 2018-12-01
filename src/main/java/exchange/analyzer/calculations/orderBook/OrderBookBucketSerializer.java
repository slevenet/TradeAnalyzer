package exchange.analyzer.calculations.orderBook;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.oanda.v20.instrument.OrderBookBucket;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class OrderBookBucketSerializer extends JsonSerializer<OrderBookBucket> {
	@Override
	public void serialize(OrderBookBucket bucket,
						  JsonGenerator jsonGenerator,
						  SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeStartObject();

		jsonGenerator.writeStringField("price", bucket.getPrice().toString());
		jsonGenerator.writeStringField("longCountPercent", bucket.getLongCountPercent().toString());
		jsonGenerator.writeStringField("shortCountPercent", bucket.getShortCountPercent().toString());

		jsonGenerator.writeEndObject();
	}
}
