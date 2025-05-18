package com.example.ss10.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
    private MultipartFile file;
    private String description;

    public UploadFile() {}

    public UploadFile(MultipartFile file, String description) {
        this.file = file;
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

