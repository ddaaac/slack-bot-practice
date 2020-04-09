package domain.message;

import com.google.gson.Gson;

public class SlackPostMessage {
    private static final String CHANNEL_NAME = "C011J0E62TF";

    private final String channel;
    private final String text;

    private SlackPostMessage(String channel, String text) {
        this.channel = channel;
        this.text = text;
    }

    public static SlackPostMessage of(String text) {
        return new SlackPostMessage(CHANNEL_NAME, text);
    }

    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
