package com.example.ss7.model;

public class Feedback {
    private String name;
    private String phone;
    private String address;
    private String content;

    public Feedback(String address, String content, String name, String phone) {
        this.address = address;
        this.content = content;
        this.name = name;
        this.phone = phone;
    }

    public Feedback() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

