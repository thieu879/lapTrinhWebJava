package com.data.ss15.model.bt6;

public class Product {
    private String idProduct;
    private String productName;
    private double price;
    private String category;
    private String image;

    // Constructor, getter, setter
    public Product() {}

    public Product(String idProduct, String productName, double price, String category, String image) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    public String getIdProduct() { return idProduct; }
    public void setIdProduct(String idProduct) { this.idProduct = idProduct; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}


