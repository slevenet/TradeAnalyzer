package exchange.analyzer.calculations.orderBook;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.instrument.OrderBookBucket;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class OrderBookSerializer extends JsonSerializer<OrderBook> {
	@Override
	public void serialize(OrderBook orderBook,
						  JsonGenerator jsonGenerator,
						  SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeStartObject();

		jsonGenerator.writeStringField("instrument", orderBook.getInstrument().toString());
		jsonGenerator.writeStringField("time", orderBook.getTime().toString());
		jsonGenerator.writeStringField("price", orderBook.getPrice().toString());
		jsonGenerator.writeStringField("bucketWidth", orderBook.getBucketWidth().toString());

		jsonGenerator.writeFieldName("buckets");
		jsonGenerator.writeStartArray();
		for (OrderBookBucket bucket : orderBook.getBuckets())
			jsonGenerator.writeObject(bucket);

		jsonGenerator.writeEndArray();

		jsonGenerator.writeEndObject();
	}
}
