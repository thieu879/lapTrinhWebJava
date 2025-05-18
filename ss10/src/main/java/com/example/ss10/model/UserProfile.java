package com.example.ss10.model;

import org.springframework.web.multipart.MultipartFile;

public class UserProfile {
    private String username;
    private MultipartFile avatar;

    public UserProfile() {
    }

    public UserProfile(String username, MultipartFile avatar) {
        this.username = username;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
