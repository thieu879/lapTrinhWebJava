package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Cart;
import com.data.ss15.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.openConnection();
    }

    @Override
    public List<Cart> getAllCarts() {
        List<Cart> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_get_all_carts()}");
            rs = cs.executeQuery();

            while (rs.next()) {
                Cart c = new Cart(
                        rs.getString("idCart"),
                        rs.getString("idUser"),
                        rs.getString("idProduct"),
                        rs.getInt("quantity")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return list;
    }

    @Override
    public Cart getCartById(String id) {
        Cart c = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_get_cart_by_id(?)}");
            cs.setString(1, id);
            rs = cs.executeQuery();

            if (rs.next()) {
                c = new Cart(
                        rs.getString("idCart"),
                        rs.getString("idUser"),
                        rs.getString("idProduct"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return c;
    }

    @Override
    public boolean insertCart(Cart cart) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_insert_cart(?,?,?,?)}");
            cs.setString(1, cart.getIdCart());
            cs.setString(2, cart.getIdUser());
            cs.setString(3, cart.getIdProduct());
            cs.setInt(4, cart.getQuantity());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean updateCart(Cart cart) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_update_cart(?,?,?,?)}");
            cs.setString(1, cart.getIdCart());
            cs.setString(2, cart.getIdUser());
            cs.setString(3, cart.getIdProduct());
            cs.setInt(4, cart.getQuantity());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean deleteCart(String id) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_delete_cart(?)}");
            cs.setString(1, id);
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }
}



