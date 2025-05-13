package com.example.ss6.dao.cart;

import com.example.ss6.model.CartItem;
import com.example.ss6.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImp implements CartDao {
    @Override
    public List<CartItem> displayCart(int userId) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<CartItem> cartItems = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_cart(?)}");
            callSt.setInt(1, userId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("imageUrl"),
                        rs.getInt("quantity")
                );
                cartItems.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return cartItems;
    }

    @Override
    public void addToCart(int userId, int productId, int quantity) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_to_cart(?,?,?)}");
            callSt.setInt(1, userId);
            callSt.setInt(2, productId);
            callSt.setInt(3, quantity);
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void removeFromCart(int userId, int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call remove_from_cart(?,?)}");
            callSt.setInt(1, userId);
            callSt.setInt(2, productId);
            callSt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}