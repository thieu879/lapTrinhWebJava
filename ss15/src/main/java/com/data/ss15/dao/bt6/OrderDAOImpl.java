package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Order;
import com.data.ss15.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.openConnection();
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_get_all_orders()}");
            rs = cs.executeQuery();

            while (rs.next()) {
                Order o = new Order(
                        rs.getString("idOrder"),
                        rs.getString("idUser"),
                        rs.getDate("orderDate"),
                        rs.getString("status")
                );
                list.add(o);
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
    public Order getOrderById(String id) {
        Order o = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_get_order_by_id(?)}");
            cs.setString(1, id);
            rs = cs.executeQuery();

            if (rs.next()) {
                o = new Order(
                        rs.getString("idOrder"),
                        rs.getString("idUser"),
                        rs.getDate("orderDate"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return o;
    }

    @Override
    public boolean insertOrder(Order order) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_insert_order(?,?,?,?)}");
            cs.setString(1, order.getIdOrder());
            cs.setString(2, order.getIdUser());
            cs.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            cs.setString(4, order.getStatus());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_update_order(?,?,?,?)}");
            cs.setString(1, order.getIdOrder());
            cs.setString(2, order.getIdUser());
            cs.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            cs.setString(4, order.getStatus());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean deleteOrder(String id) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_delete_order(?)}");
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
