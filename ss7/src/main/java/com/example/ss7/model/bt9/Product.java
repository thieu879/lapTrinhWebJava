package com.example.ss7.model.bt9;

public class Product {
    private int id;
    private String name;
    private double price;
    private int categoryId;

    public Product(int categoryId, int id, String name, double price) {
        this.categoryId = categoryId;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
