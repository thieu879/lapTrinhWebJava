package com.example.ss7.model;

public class Product {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private String description;
    private String image;

    public Product(Long id, String description, String image, String name, Double price, Integer stock) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public Product() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
