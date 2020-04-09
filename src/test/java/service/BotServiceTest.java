package service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BotServiceTest {
    @Test
    void create() {
        String bodyAsJson = "{\"event\" : {\"bot_id\": \"idididid\"}}";
        assertThat(Services.chooseService(bodyAsJson)).isInstanceOf(BotService.class);
    }
}