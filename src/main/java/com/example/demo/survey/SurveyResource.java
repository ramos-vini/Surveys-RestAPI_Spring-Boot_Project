package com.example.demo.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SurveyResource {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping("surveys")
    public List<Survey> getAllSurveys(){
        return surveyService.getAllSurveys();
    }

    @RequestMapping("surveys/{surveyId}")
    public Survey getSurveyById(@PathVariable int surveyId){

        Survey survey = surveyService.getSurveyById(surveyId);

        if (survey == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return survey;
    }

    @RequestMapping("surveys/{surveyId}/questions")
    public List<Question> getAllQuestionsBySurveyId(@PathVariable int surveyId){
        return surveyService.getAllQuestionsBySurveyId(surveyId);
    }

    @RequestMapping("surveys/{surveyId}/questions/{questionId}")
    public Question getQuestionById(@PathVariable int surveyId, @PathVariable int questionId){

        Question question = surveyService.getQuestionById(surveyId, questionId);

        if (question == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return question;
    }
}
