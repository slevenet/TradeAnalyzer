package exchange.analyzer.calculations.orderBook;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.oanda.v20.instrument.OrderBook;
import com.oanda.v20.primitives.DateTime;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeInfo;
import exchange.analyzer.model.charts.OrderBookChart;

import java.io.IOException;
import java.util.Map;

public class OrderBookChartAdapter extends TypeAdapter<OrderBookChart> {

	private OrderAnalyzeInfoAdapter orderAnalyzeInfoAdapter = new OrderAnalyzeInfoAdapter();

	@Override
	public void write(JsonWriter jsonWriter, OrderBookChart orderBookChart) throws IOException {
		jsonWriter.beginObject();

		jsonWriter.name("instrumentName").value(orderBookChart.getInstrumentName().toString());

		jsonWriter.name("orderBooks");
		jsonWriter.beginObject();
		for (Map.Entry<DateTime, OrderBook> entry : orderBookChart.getOrderBookMap().entrySet()) {
			jsonWriter.name(entry.getKey().toString()).value(entry.getValue().toString());
		}
		jsonWriter.endObject();

		jsonWriter.name("orderAnalyzeInfo");
		jsonWriter.beginObject();
		for (Map.Entry<DateTime, OrderAnalyzeInfo> entry : orderBookChart.getAnalyzeResultMap().entrySet()) {
			jsonWriter.name(entry.getKey().toString()).value(entry.getValue().toString());
		}
		jsonWriter.endObject();

		jsonWriter.endObject();
	}

	@Override
	public OrderBookChart read(JsonReader jsonReader) throws IOException {
		return null;
	}
}
