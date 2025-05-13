package com.example.ss6.service;

import com.example.ss6.dao.cart.CartDao;
import com.example.ss6.dao.cart.CartDaoImp;
import com.example.ss6.model.CartItem;

import java.util.List;

public class CartServiceImp implements CartService {
    private final CartDao cartDao;

    public CartServiceImp() {
        cartDao = new CartDaoImp();
    }

    @Override
    public List<CartItem> displayCart(int userId) {
        return cartDao.displayCart(userId);
    }

    @Override
    public void addToCart(int userId, int productId, int quantity) {
        cartDao.addToCart(userId, productId, quantity);
    }

    @Override
    public void removeFromCart(int userId, int productId) {
        cartDao.removeFromCart(userId, productId);
    }
}