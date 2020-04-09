package domain.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PostHandler {
    private final String url;
    private final String bodyAsJson;
    private final Map<String, String> headers;

    PostHandler(String url, String bodyAsJson, Map<String, String> headers) {
        this.url = url;
        this.bodyAsJson = bodyAsJson;
        this.headers = headers;
    }

    public String send() throws IOException {
        // URL
        URL postUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();

        // POST 설정
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        // 전송
        try (OutputStream os = connection.getOutputStream()) {
            os.write(bodyAsJson.getBytes(StandardCharsets.UTF_8));
            os.flush();
        }

        // 응답
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }
}
