package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> getAllCarts();
    Cart getCartById(String id);
    boolean insertCart(Cart cart);
    boolean updateCart(Cart cart);
    boolean deleteCart(String id);
}

