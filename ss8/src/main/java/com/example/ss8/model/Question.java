package com.example.ss8.model;

public class Question {
    private int id;
    private String imageUrl;
    private String answer;

    public Question() {}

    public Question(int id, String imageUrl, String answer) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

