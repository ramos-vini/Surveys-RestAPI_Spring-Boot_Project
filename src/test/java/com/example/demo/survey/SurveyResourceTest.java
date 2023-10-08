package com.example.demo.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyResourceTest {

    // /localhost:RANDOM_PORT/
    @Autowired
    TestRestTemplate template;

    @Test
    void getQuestionById_question1() throws JSONException {

        String questionUri = "/surveys/1/questions/1";

        String expectedResponse = """
            {
                "id": 1,
                "description": "Most Popular Cloud Platform Today",
                "correctAnswer": "AWS"
            }
            """;

        ResponseEntity<String> actualResponse = template.getForEntity(questionUri, String.class);

        // Status Code
        assertTrue(actualResponse.getStatusCode().is2xxSuccessful());

        // JSON Format
        assertEquals("application/json", actualResponse.getHeaders().get("Content-Type").get(0));

        // Response Body
        JSONAssert.assertEquals(expectedResponse, actualResponse.getBody(), false);
    }
}
