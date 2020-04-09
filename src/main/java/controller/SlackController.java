package controller;

import service.Services;
import service.SlackService;

import java.io.IOException;

import static spark.Spark.post;

public class SlackController {
    public void run() {
        post("/", (req, res) -> {
            String body = req.body();
            System.out.println(body);

            try {
                SlackService slackService = Services.chooseService(body);
                slackService.process();
            } catch (IOException e) {
                System.out.println(String.format("error: %s", e.getMessage()));
            }

            res.status(200);
            return "Hello";
        });
    }
}
