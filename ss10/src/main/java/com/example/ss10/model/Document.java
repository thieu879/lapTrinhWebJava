package com.example.ss10.model;

import org.springframework.web.multipart.MultipartFile;

public class Document {
    private String title;
    private String description;
    private MultipartFile file;

    public Document() {
    }

    public Document(String title, String description, MultipartFile file) {
        this.title = title;
        this.description = description;
        this.file = file;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

