package com.example.ss4.bt6;

public class Student {
    private int id;
    private String name;
    private double point;
    private String address;

    public Student(int id, String name, double point, String address) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
