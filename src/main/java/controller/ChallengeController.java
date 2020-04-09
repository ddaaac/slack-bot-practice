package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import domain.request.BodyParser;

import static spark.Spark.post;

public class ChallengeController {
    public void run() {
        post("/", (req, res) -> {
            BodyParser bodyParser = new BodyParser(req.body());
            String challenge = bodyParser.getValueOf("challenge").orElse("input text가 없습니다.");

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("challenge", challenge);
            return new Gson().toJson(jsonObject);
        });
    }
}
