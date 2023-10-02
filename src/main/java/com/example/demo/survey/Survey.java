package com.example.demo.survey;

import java.util.List;

public class Survey {

    public Survey(int id, String name, String description, List<Question> questions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public Survey() {}

    private int id;
    private String name;
    private String description;
    private List<Question> questions;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
