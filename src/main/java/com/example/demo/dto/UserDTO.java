package com.example.demo.dto;

import com.example.demo.model.Role;

public class UserDTO {
    private String name;
    private String email;
    private String password;
    private Role role;
    private String resumeUrl;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getResumeUrl() {
        return resumeUrl;
    }
    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
}
