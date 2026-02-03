package com.example.demo.dto;

import java.util.List;

public class QuizDTO {

    private String title;
    private List<String> questions;
    private String createdBy;

    // Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getQuestions() {
        return questions;
    }
    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
