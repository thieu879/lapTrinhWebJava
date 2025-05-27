package com.data.onhackathon.dto;

public class ProductDTO {
    private String productName;
    private Integer price;
    private String description;
    private String status;
    private String image;

    public ProductDTO() {}
    public ProductDTO(String productName, Integer price, String description, String status) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
