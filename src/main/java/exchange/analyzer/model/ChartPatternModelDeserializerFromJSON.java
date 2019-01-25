package exchange.analyzer.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import exchange.analyzer.model.charts.ChartPatternModel;

import java.lang.reflect.Type;

public class ChartPatternModelDeserializerFromJSON implements JsonDeserializer<ChartPatternModel> {
    @Override
    public ChartPatternModel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
