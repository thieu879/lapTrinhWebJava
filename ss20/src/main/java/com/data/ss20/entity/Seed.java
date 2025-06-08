package com.data.ss20.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Seed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = true, columnDefinition = "varchar(100)")
    private String seedName;
    private String description;
    @Min(value = 1, message = "Giá phải lớn hơn 0")
    private int price;
    @Min(value = 0, message = "Số lượng phải lớn hơn hoặc bằng 0")
    private int stock;
    private String image;

    public Seed() {
    }
    public Seed(Long id, String seedName, String description, int price, int stock, String image) {
        this.id = id;
        this.seedName = seedName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
