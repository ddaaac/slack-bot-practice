package domain.message;

import org.junit.jupiter.api.Test;

class SlackPostMessageTest {
    @Test
    void getGson() {
        System.out.println(SlackPostMessage.of("text").getJson());
    }
}