package com.data.ss15.model;

public class Student {
    private String id;
    private String name;
    private int age;
    private String classroom;
    private String email;
    private String address;
    private String phoneNumber;

    public Student() {
    }
    public Student(String id, String name, int age, String classroom, String email, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classroom = classroom;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
