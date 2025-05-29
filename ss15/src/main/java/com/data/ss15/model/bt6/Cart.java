package com.data.ss15.model.bt6;

public class Cart {
    private String idCart;
    private String idUser;
    private String idProduct;
    private int quantity;

    public Cart() {}

    public Cart(String idCart, String idUser, String idProduct, int quantity) {
        this.idCart = idCart;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public String getIdCart() { return idCart; }
    public void setIdCart(String idCart) { this.idCart = idCart; }

    public String getIdUser() { return idUser; }
    public void setIdUser(String idUser) { this.idUser = idUser; }

    public String getIdProduct() { return idProduct; }
    public void setIdProduct(String idProduct) { this.idProduct = idProduct; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

