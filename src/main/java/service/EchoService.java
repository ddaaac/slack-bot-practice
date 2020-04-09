package service;

import domain.message.IncomingMessageType;
import domain.message.SlackPostMessage;
import domain.request.BodyParser;
import domain.request.PostHandlerFactory;

import java.io.IOException;

public class EchoService extends ProcessingService {
    public EchoService(String body) {
        super(body);
    }

    @Override
    void processWithBody(BodyParser body) throws IOException {
        String text = body.getValueOf("event", "text").orElse("input text가 없습니다.");

        PostHandlerFactory.createSlackPostMessage(SlackPostMessage.of(text).getJson()).send();
    }

    public static boolean support(String body) {
        return IncomingMessageType.APP_MENTIONED.isTypeOf(new BodyParser(body));
    }
}
