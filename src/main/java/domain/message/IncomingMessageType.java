package domain.message;

import domain.request.BodyParser;

import java.util.function.Predicate;

public enum IncomingMessageType {
    MESSAGE(body -> body.getValueOf("event", "type").orElse("").equals("message")),
    APP_MENTIONED(body -> body.getValueOf("event", "type").orElse("").equals("app_mention"));

    private Predicate<BodyParser> filterByBody;

    IncomingMessageType(Predicate<BodyParser> filterByBody) {
        this.filterByBody = filterByBody;
    }

    public boolean isTypeOf(BodyParser body) {
        return filterByBody.test(body);
    }
}
