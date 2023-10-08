package com.example.demo.survey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyResourceTest {

    // /localhost:RANDOM_PORT/
    @Autowired
    TestRestTemplate template;

    String question1_response = """
            {
                "id": 1,
                "description": "Most Popular Cloud Platform Today",
                "options": [
                    "AWS",
                    "Azure",
                    "Google Cloud",
                    "Oracle Cloud"
                ],
                "correctAnswer": "AWS"
            }
            """;

    String question1_uri = "/surveys/1/questions/1";

    @Test
    void getQuestionById_standard(){
        ResponseEntity<String> responseEntity = template.getForEntity(question1_uri,String.class);
        System.out.println(responseEntity.getBody());
    }
}
