package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "videos")
public class Vedio {

    @Id
    private String id;

    private String mentorId;
    private String title;
    private String description;
    private String subject;
    private String videoUrl;
    private LocalDateTime uploadDate;

    // Constructors
    public Vedio() {
        this.uploadDate = LocalDateTime.now();
    }

    public Vedio(String mentorId, String title, String description, String subject, String videoUrl) {
        this.mentorId = mentorId;
        this.title = title;
        this.description = description;
        this.subject = subject;
        this.videoUrl = videoUrl;
        this.uploadDate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Vedio{" +
                "id='" + id + '\'' +
                ", mentorId='" + mentorId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subject='" + subject + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
