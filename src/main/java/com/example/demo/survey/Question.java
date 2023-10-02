package com.example.demo.survey;

import java.util.List;

public class Question {

    public Question(int id, String description, List<String> options, String correctAnswer) {
        this.id = id;
        this.description = description;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public Question() {}

    private int id;
    private String description;
    private List<String> options;
    private String correctAnswer;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
