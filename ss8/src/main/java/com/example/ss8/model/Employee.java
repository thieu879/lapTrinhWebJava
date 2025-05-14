package com.example.ss8.model;

public class Employee {
    private String name;
    private String email;
    private String position;

    public Employee() {
    }

    public Employee(String name, String email, String position) {
        this.name = name;
        this.email = email;
        this.position = position;
    }

    // Getters & Setters
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

