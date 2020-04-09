package domain.request;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PostHandlerTest {
    @Test
    void send() throws IOException {
        String url = "https://postman-echo.com/post?foo1=bar1";
        String bodyAsJson = "{\"key\": \"value\"}";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String response = new PostHandler(url, bodyAsJson, headers).send();

        assertThat(new BodyParser(response).getValueOf("data", "key").orElse("")).isEqualTo("value");
    }

    @Test
    void sendToInvalidURL() {
        String url = "invalidURL";
        String bodyAsJson = "{\"key\": \"value\"}";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        assertThatThrownBy(() -> {
            new PostHandler(url, bodyAsJson, headers).send();
        }).isInstanceOf(MalformedURLException.class);
    }
}