package exchange.analyzer.calculations.orderBook;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.oanda.v20.instrument.OrderBookBucket;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeResult;

import java.io.IOException;

public class OrderAnalyzeResultAdapter extends TypeAdapter<OrderAnalyzeResult> {
	@Override
	public void write(JsonWriter jsonWriter, OrderAnalyzeResult orderAnalyzeResult) throws IOException {
		jsonWriter.setLenient(true);
		jsonWriter.beginObject();

		jsonWriter.name("orderExist").value(orderAnalyzeResult.isOrderExist());
		jsonWriter.name("isNearestBuy").value(orderAnalyzeResult.isNearestBuy());
		jsonWriter.name("isNearestSell").value(orderAnalyzeResult.isNearestSell());
		jsonWriter.name("buyOrderPercent").value(orderAnalyzeResult.getBuyOrderPercent());
		jsonWriter.name("sellOrderPercent").value(orderAnalyzeResult.getSellOrderPercent());

		OrderBookBucket nearestBuy = orderAnalyzeResult.getNearestBuy();
		OrderBookBucket nearestSell = orderAnalyzeResult.getNearestSell();
		jsonWriter.name("nearestBuy").value(nearestBuy != null ? nearestBuy.toString() : "null");
		jsonWriter.name("nearestSell").value(nearestSell != null ? nearestSell.toString() : "null");

		jsonWriter.endObject();
		jsonWriter.close();
	}

	@Override
	public OrderAnalyzeResult read(JsonReader jsonReader) throws IOException {
		return null;
	}
}
