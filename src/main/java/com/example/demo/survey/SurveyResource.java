package com.example.demo.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Survey getSurveyById(@PathVariable String surveyId){

        Survey survey = surveyService.getSurveyById(surveyId);

        if (survey == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return survey;
    }
}
