package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String resumeUrl;
    private boolean isApprovedMentor;
    private LocalDateTime createdDate;

    public User() {
        this.createdDate = LocalDateTime.now();
        this.isApprovedMentor = false;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public String getResumeUrl() { return resumeUrl; }
    public void setResumeUrl(String resumeUrl) { this.resumeUrl = resumeUrl; }

    public boolean isApprovedMentor() { return isApprovedMentor; }
    public void setApprovedMentor(boolean isApprovedMentor) { this.isApprovedMentor = isApprovedMentor; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password +
               ", role=" + role + ", resumeUrl=" + resumeUrl + ", isApprovedMentor=" + isApprovedMentor +
               ", createdDate=" + createdDate + "]";
    }
}