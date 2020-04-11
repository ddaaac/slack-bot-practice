package service;

import domain.request.BodyParser;

import java.io.IOException;

public class BotService extends ProcessingService {
    BotService(String body) {
        super(body);
    }

    @Override
    void processWithBody(BodyParser body) throws IOException {
    }

    public static boolean support(String body) {
        // TODO: 2020/04/08 Optional isPresent 개선
        return new BodyParser(body).getValueOf("event", "bot_id").isPresent();
    }
}
