package com.data.onhackathon.model;

import java.time.LocalDateTime;

public class Product {
    private Integer id;
    private String productName;
    private Integer price;
    private String description;
    private String image;
    private String status;
    private LocalDateTime createdAt;

    public Product() {}
    public Product(Integer id, String productName, Integer price, String description, String image, String status, LocalDateTime createdAt) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.status = status;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
