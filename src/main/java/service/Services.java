package service;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * support는 위부터 아래로 진행되며 필터링하기 때문에 순서가 중요함
 */
public enum Services {
    BOT(BotService::new, BotService::support),
    ECHO(EchoService::new, EchoService::support),
    DO_NOTHING(DoNothingService::new, DoNothingService::support);

    private Function<String, SlackService> serviceCreator;
    private Predicate<String> support;

    Services(Function<String, SlackService> serviceCreator, Predicate<String> support) {
        this.serviceCreator = serviceCreator;
        this.support = support;
    }

    public static SlackService chooseService(String body) {
        return Stream.of(values())
                .filter(service -> service.support.test(body))
                .map(service -> service.serviceCreator.apply(body))
                .findFirst()
                .orElse(DO_NOTHING.serviceCreator.apply(body));
    }
}
