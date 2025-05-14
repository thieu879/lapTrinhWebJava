package com.example.ss7.model;

public class Products {
    private String name;
    private String color;
    private String size;

    public Products(String color, String name, String size) {
        this.color = color;
        this.name = name;
        this.size = size;
    }
    public Products() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
