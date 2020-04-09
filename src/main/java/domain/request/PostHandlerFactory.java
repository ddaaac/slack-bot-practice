package domain.request;

import util.KeyReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostHandlerFactory {
    private static final String SLACK_POST_MESSAGE_URL = "https://slack.com/api/chat.postMessage";

    public static PostHandler createSlackPostMessage(String bodyAsJson) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", KeyReader.getKey());

        return new PostHandler(SLACK_POST_MESSAGE_URL, bodyAsJson, headers);
    }
}
