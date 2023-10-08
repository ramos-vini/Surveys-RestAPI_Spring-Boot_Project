package com.example.demo.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyResourceTest {

    // /localhost:RANDOM_PORT/
    @Autowired
    TestRestTemplate template;

    @Test
    void getQuestionById_standard() throws JSONException {

        String questionUri = "/surveys/1/questions/1";

        String expectedResponse = """
            {
                "id": 1,
                "description": "Most Popular Cloud Platform Today",
                "correctAnswer": "AWS"
            }
            """;

        ResponseEntity<String> actualResponse = template.getForEntity(questionUri, String.class);

        JSONAssert.assertEquals(expectedResponse, actualResponse.getBody(), false);
    }
}
