package com.example.ss4.bt1;

public class Product {
    private int id;
    private String productName;
    private String price;
    private String description;

    public Product(String description, int id, String price, String productName) {
        this.description = description;
        this.id = id;
        this.price = price;
        this.productName = productName;
    }

    public Product() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
