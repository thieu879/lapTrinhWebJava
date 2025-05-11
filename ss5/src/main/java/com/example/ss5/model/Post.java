package com.example.ss5.model;

public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private String publishDate;

    public Post(int id, String title, String content, String author, String publishDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
    }

    // Getters và setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public String getPublishDate() { return publishDate; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }
}

