package domain.request;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Optional;

public class BodyParser {
    private final String body;

    public BodyParser(String body) {
        this.body = body;
    }

    public Optional<String> getValueOf(String... keys) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(body);
        for (String key : keys) {
            JsonObject jsonObject = element.getAsJsonObject();
            if (!jsonObject.has(key)) {
                return Optional.empty();
            }
            element = jsonObject.get(key);
        }
        return Optional.of(element.getAsString());
    }
}
