package controller;

import domain.message.SlackPostMessage;
import domain.request.BodyParser;
import domain.request.PostHandlerFactory;

import java.io.IOException;

import static spark.Spark.post;

public class SlackController {
    public void run() {
        post("/", (req, res) -> {
            BodyParser bodyParser = new BodyParser(req.body());
            // TODO: 2020/04/08 Optional isPresent 개선
            // Bot의 정보가 들어왔다면 끝냄
            if (bodyParser.getValueOf("event", "bot_id").isPresent()) {
                return null;
            }
            String text = bodyParser.getValueOf("event", "text").orElse("input text가 없습니다.");

            try {
                PostHandlerFactory.createSlackPostMessage(SlackPostMessage.of(text).getJson()).send();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            res.status(200);
            return "Hello";
        });
    }
}
