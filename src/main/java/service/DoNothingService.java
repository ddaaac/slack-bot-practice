package service;

import domain.request.BodyParser;

public class DoNothingService extends ProcessingService {
    DoNothingService(String body) {
        super(body);
    }

    @Override
    void processWithBody(BodyParser body) {
    }

    public static boolean support(String body) {
        return false;
    }
}
