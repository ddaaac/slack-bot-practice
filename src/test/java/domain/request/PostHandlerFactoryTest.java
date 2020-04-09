package domain.request;

import domain.message.SlackPostMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class PostHandlerFactoryTest {
    @Test
    @DisplayName("슬랙 chat.postMessage api 전송")
    void slackPostMessage() throws IOException {
        String message = SlackPostMessage.of("test message").getJson();
        PostHandler slackPostMessage = PostHandlerFactory.createSlackPostMessage(message);
        String response = slackPostMessage.send();
        assertThat(new BodyParser(response).getValueOf("ok").orElse(null)).isEqualTo("true");
    }
}