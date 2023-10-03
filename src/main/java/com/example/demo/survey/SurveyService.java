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

    private static int lastSurveyId = 0;

    private static int lastQuestionId = 0;

    static {
        Question question1 = new Question(++lastQuestionId,
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question(++lastQuestionId,
                "Fastest Growing Cloud Platform", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question(++lastQuestionId,
                "Most Popular DevOps Tool", Arrays.asList(
                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));

        Survey survey = new Survey(++lastSurveyId, "My Favorite Survey",
                "Description of the Survey", questions);

        surveys.add(survey);
    }

    int getSurveyId() {
        return lastSurveyId;
    }

    int getQuestionId() {
        return lastQuestionId;
    }

    // GET Methods

    List<Survey> getAllSurveys() {
        return surveys;
    }

    Survey getSurveyById(int surveyId) {

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
        Optional<Question> optionalQuestion = questions.stream().filter(q -> q.getId() == questionId).findFirst();
        return optionalQuestion.orElse(null);
    }

    // POST Methods

    void addQuestion(int surveyId, Question question) {
        Survey survey = getSurveyById(surveyId);
        question.setId(++lastQuestionId);
        survey.getQuestions().add(question);
    }

    void addQuestionKeepId(int surveyId, int questionId, Question question) {
        Survey survey = getSurveyById(surveyId);
        question.setId(questionId);
        survey.getQuestions().add(question);
    }

    // DELETE Methods

    public boolean deleteQuestionById(int surveyId, int questionId) {
        List<Question> questions = getAllQuestionsBySurveyId(surveyId);

        return questions.removeIf(question -> question.getId() == questionId);
    }

    // PUT Methods

    public boolean updateQuestionById(int surveyId, int questionId, Question question) {
        boolean exists = deleteQuestionById(surveyId, questionId);

        if (!exists) return false;

        addQuestionKeepId(surveyId, questionId, question);
        return true;
    }
}
