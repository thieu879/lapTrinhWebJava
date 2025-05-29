package com.data.ss15.service.bt6;

import com.data.ss15.dao.bt6.CartDAO;
import com.data.ss15.dao.bt6.CartDAOImpl;
import com.data.ss15.model.bt6.Cart;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDAO cartDAO = new CartDAOImpl();

    @Override
    public List<Cart> getAllCarts() {
        return cartDAO.getAllCarts();
    }

    @Override
    public Cart getCartById(String id) {
        return cartDAO.getCartById(id);
    }

    @Override
    public boolean addCart(Cart cart) {
        return cartDAO.insertCart(cart);
    }

    @Override
    public boolean updateCart(Cart cart) {
        return cartDAO.updateCart(cart);
    }

    @Override
    public boolean deleteCart(String id) {
        return cartDAO.deleteCart(id);
    }
}


