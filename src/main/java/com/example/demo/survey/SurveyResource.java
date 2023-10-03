package com.example.demo.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SurveyResource {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("surveys")
    public List<Survey> getAllSurveys(){
        return surveyService.getAllSurveys();
    }

    @GetMapping("surveys/{surveyId}")
    public Survey getSurveyById(@PathVariable int surveyId){

        Survey survey = surveyService.getSurveyById(surveyId);

        if (survey == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return survey;
    }

    @GetMapping("surveys/{surveyId}/questions")
    public List<Question> getAllQuestionsBySurveyId(@PathVariable int surveyId){
        return surveyService.getAllQuestionsBySurveyId(surveyId);
    }

    @PostMapping("surveys/{surveyId}/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public void addQuestion(@PathVariable int surveyId, @RequestBody Question question){
        surveyService.addQuestion(surveyId, question);
    }

    @GetMapping("surveys/{surveyId}/questions/{questionId}")
    public Question getQuestionById(@PathVariable int surveyId, @PathVariable int questionId){

        Question question = surveyService.getQuestionById(surveyId, questionId);

        if (question == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return question;
    }
}
