package com.example.demo.dto;

public class VideoDTO {

    private String mentorId;
    private String title;
    private String description;
    private String subject;
    private String videoUrl;

    // Constructors
    public VideoDTO() {}

    public VideoDTO(String mentorId, String title, String description, String subject, String videoUrl) {
        this.mentorId = mentorId;
        this.title = title;
        this.description = description;
        this.subject = subject;
        this.videoUrl = videoUrl;
    }

    // Getters and Setters
    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
