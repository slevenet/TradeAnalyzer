package exchange.analyzer.calculations.orderBook;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import exchange.analyzer.calculations.orderBook.orderAnalyze.OrderAnalyzeInfo;

import java.io.IOException;

public class OrderAnalyzeInfoAdapter extends TypeAdapter<OrderAnalyzeInfo> {

	private OrderAnalyzeResultAdapter orderAnalyzeResultAdapter = new OrderAnalyzeResultAdapter();

	@Override
	public void write(JsonWriter jsonWriter, OrderAnalyzeInfo analyzeInfo) throws IOException {
		jsonWriter.beginObject();

//		jsonWriter.name("stopLossResult").value(orderAnalyzeResultAdapter.toJson(analyzeInfo.getStopLossResult()));
//		jsonWriter.name("takeProfitResult").value(orderAnalyzeResultAdapter.toJson(analyzeInfo.getTakeProfitResult()));

		jsonWriter.name("stopLossResult").value(analyzeInfo.getStopLossResult().toString());
		jsonWriter.name("takeProfitResult").value(analyzeInfo.getTakeProfitResult().toString());

		jsonWriter.endObject();
	}

	@Override
	public OrderAnalyzeInfo read(JsonReader jsonReader) throws IOException {
		return null;
	}
}
