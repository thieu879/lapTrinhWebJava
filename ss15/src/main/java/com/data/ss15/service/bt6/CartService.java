package com.data.ss15.service.bt6;

import com.data.ss15.model.bt6.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCartById(String id);
    boolean addCart(Cart cart);
    boolean updateCart(Cart cart);
    boolean deleteCart(String id);
}

