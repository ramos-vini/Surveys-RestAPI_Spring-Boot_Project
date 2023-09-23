package com.example.demo.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyResource {

    @Autowired
    private SurveyService surveyService;

    @RequestMapping("surveys")
    public List<Survey> getAllSurveys(){
        return surveyService.getAllSurveys();
    }
}
