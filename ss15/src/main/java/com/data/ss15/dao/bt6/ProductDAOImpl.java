package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private Connection getConnection() throws SQLException {
        // Thay thông tin DB cho phù hợp
        String url = "jdbc:mysql://localhost:3306/yourdb";
        String user = "root";
        String pass = "123456";
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_get_all_products()}");
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getString("idProduct"),
                        rs.getString("productName"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getString("image")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getProductById(String id) {
        Product p = null;
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_get_product_by_id(?)}")) {

            cs.setString(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    p = new Product(
                            rs.getString("idProduct"),
                            rs.getString("productName"),
                            rs.getDouble("price"),
                            rs.getString("category"),
                            rs.getString("image")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean insertProduct(Product product) {
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_insert_product(?,?,?,?,?)}")) {

            cs.setString(1, product.getIdProduct());
            cs.setString(2, product.getProductName());
            cs.setDouble(3, product.getPrice());
            cs.setString(4, product.getCategory());
            cs.setString(5, product.getImage());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_update_product(?,?,?,?,?)}")) {

            cs.setString(1, product.getIdProduct());
            cs.setString(2, product.getProductName());
            cs.setDouble(3, product.getPrice());
            cs.setString(4, product.getCategory());
            cs.setString(5, product.getImage());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(String id) {
        try (Connection conn = getConnection();
             CallableStatement cs = conn.prepareCall("{call sp_delete_product(?)}")) {

            cs.setString(1, id);
            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}




