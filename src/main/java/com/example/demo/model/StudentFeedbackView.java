package com.example.demo.model;

public class StudentFeedbackView {
    private String videoId;
    private String studentId;
    private String comment;
    private int rating;

    // Constructors
    public StudentFeedbackView() {}

    public StudentFeedbackView(String videoId, String studentId, String comment, int rating) {
        this.videoId = videoId;
        this.studentId = studentId;
        this.comment = comment;
        this.rating = rating;
    }

    // Getters and Setters
    public String getVideoId() {
        return videoId;
    }
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
