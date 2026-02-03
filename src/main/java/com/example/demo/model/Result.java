package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "results")
public class Result {

    @Id
    private String id;
    private String studentId;
    private String quizId;
    private int score;
    private LocalDateTime submittedDate;

    public Result() {
        this.submittedDate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getQuizId() {
        return quizId;
    }
    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getSubmittedDate() {
        return submittedDate;
    }
    public void setSubmittedDate(LocalDateTime submittedDate) {
        this.submittedDate = submittedDate;
    }

    @Override
    public String toString() {
        return "Result [id=" + id + ", studentId=" + studentId + ", quizId=" + quizId +
                ", score=" + score + ", submittedDate=" + submittedDate + "]";
    }
}
