package com.example.ss6.dao.cart;

import com.example.ss6.model.CartItem;

import java.util.List;

public interface CartDao {
    List<CartItem> displayCart(int userId);
    void addToCart(int userId, int productId, int quantity);
    void removeFromCart(int userId, int productId);
}