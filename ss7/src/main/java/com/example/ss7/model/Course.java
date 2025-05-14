package com.example.ss7.model;

public class Course {
    private int id;
    private String name;
    private String description;

    public Course(String description, int id, String name) {
        this.description = description;
        this.id = id;
        this.name = name;
    }

    public Course() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
