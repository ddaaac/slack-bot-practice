package service;

import domain.request.BodyParser;

import java.io.IOException;

public abstract class ProcessingService implements SlackService {
    private final BodyParser body;

    private ProcessingService(BodyParser body) {
        this.body = body;
    }

    ProcessingService(String body) {
        this(new BodyParser(body));
    }

    @Override
    public void process() throws IOException {
        processWithBody(body);
    }

    abstract void processWithBody(BodyParser body) throws IOException;
}
