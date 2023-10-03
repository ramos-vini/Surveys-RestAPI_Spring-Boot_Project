package com.example.demo.survey;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class SurveyService {

    // Static "DB"
    private static List<Survey> surveys = new ArrayList<>();

    private static int id = 0;

    static {
        Question question1 = new Question(++id,
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question(++id,
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question(++id,
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        Survey survey = new Survey(1, "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }

    // GET Methods

    List<Survey> getAllSurveys() {
        return surveys;
    }

    public Survey getSurveyById(int surveyId) {

        Predicate<Survey> predicate = survey -> survey.getId() == surveyId;

        Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();

        return optionalSurvey.orElse(null);
    }

    List<Question> getAllQuestionsBySurveyId(int surveyId){
        Survey survey = getSurveyById(surveyId);
        return survey.getQuestions();
    }

    Question getQuestionById(int surveyId, int questionId){
        List<Question> questions = getAllQuestionsBySurveyId(surveyId);
        Optional<Question> optionalQuestion = questions.stream().filter(question -> question.getId() == questionId).findFirst();
        return optionalQuestion.orElse(null);
    }

    // POST Methods

    public void addQuestion(int surveyId, Question question) {
        Survey survey = getSurveyById(surveyId);
        question.setId(++id);
        survey.getQuestions().add(question);
    }
}
