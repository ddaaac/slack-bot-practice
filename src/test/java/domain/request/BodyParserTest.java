package domain.request;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BodyParserTest {
    @Test
    void parse() {
        String testMessage = "{\"token\":\"Bytg8tllrqE3VpfKbMqVEBiL\",\"team_id\":\"TU6JK6TRQ\",\"api_app_id\":\"AUKCWMNSC\",\"event\":{\"bot_id\":\"B011CAXJQDQ\",\"type\":\"message\",\"text\":\"hi\",\"user\":\"U011CAXJREE\",\"ts\":\"1586348795.003800\",\"team\":\"TU6JK6TRQ\",\"bot_profile\":{\"id\":\"B011CAXJQDQ\",\"deleted\":false,\"name\":\"app-test\",\"updated\":1586325410,\"app_id\":\"AUKCWMNSC\",\"icons\":{\"image_36\":\"https:\\/\\/a.slack-edge.com\\/80588\\/img\\/plugins\\/app\\/bot_36.png\",\"image_48\":\"https:\\/\\/a.slack-edge.com\\/80588\\/img\\/plugins\\/app\\/bot_48.png\",\"image_72\":\"https:\\/\\/a.slack-edge.com\\/80588\\/img\\/plugins\\/app\\/service_72.png\"},\"team_id\":\"TU6JK6TRQ\"},\"channel\":\"C011J0E62TF\",\"event_ts\":\"1586348795.003800\",\"channel_type\":\"channel\"},\"type\":\"event_callback\",\"event_id\":\"Ev011D86BCUA\",\"event_time\":1586348795,\"authed_users\":[\"U011CAXJREE\"]}\n";
        assertThat(new BodyParser(testMessage).getValueOf("event", "text").get()).isEqualTo("hi");
    }

    @Test
    void parseNonExistingKey() {
        String testMessage = "{\"token\":\"Bytg8tllrqE3VpfKbMqVEBiL\",\"team_id\":\"TU6JK6TRQ\",\"api_app_id\":\"AUKCWMNSC\",\"event\":{\"bot_id\":\"B011CAXJQDQ\",\"type\":\"message\",\"text\":\"hi\",\"user\":\"U011CAXJREE\",\"ts\":\"1586348795.003800\",\"team\":\"TU6JK6TRQ\",\"bot_profile\":{\"id\":\"B011CAXJQDQ\",\"deleted\":false,\"name\":\"app-test\",\"updated\":1586325410,\"app_id\":\"AUKCWMNSC\",\"icons\":{\"image_36\":\"https:\\/\\/a.slack-edge.com\\/80588\\/img\\/plugins\\/app\\/bot_36.png\",\"image_48\":\"https:\\/\\/a.slack-edge.com\\/80588\\/img\\/plugins\\/app\\/bot_48.png\",\"image_72\":\"https:\\/\\/a.slack-edge.com\\/80588\\/img\\/plugins\\/app\\/service_72.png\"},\"team_id\":\"TU6JK6TRQ\"},\"channel\":\"C011J0E62TF\",\"event_ts\":\"1586348795.003800\",\"channel_type\":\"channel\"},\"type\":\"event_callback\",\"event_id\":\"Ev011D86BCUA\",\"event_time\":1586348795,\"authed_users\":[\"U011CAXJREE\"]}\n";
        assertThat(new BodyParser(testMessage).getValueOf("event", "user_id").orElse(null)).isEqualTo(null);
    }
}