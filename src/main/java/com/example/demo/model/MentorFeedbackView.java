package com.example.demo.model;

import java.time.LocalDateTime;

public class MentorFeedbackView {
    private String id;
    private String videoId;
    private String studentId;
    private String comment;
    private int rating;
    private LocalDateTime postedDate;

    // Constructors
    public MentorFeedbackView() {}

    public MentorFeedbackView(String id, String videoId, String studentId, String comment, int rating, LocalDateTime postedDate) {
        this.id = id;
        this.videoId = videoId;
        this.studentId = studentId;
        this.comment = comment;
        this.rating = rating;
        this.postedDate = postedDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

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

    public LocalDateTime getPostedDate() {
        return postedDate;
    }
    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }
}
