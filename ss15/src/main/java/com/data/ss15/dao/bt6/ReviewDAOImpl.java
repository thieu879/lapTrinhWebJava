package com.data.ss15.dao.bt6;

import com.data.ss15.model.bt6.Review;
import com.data.ss15.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    private Connection getConnection() throws SQLException {
        return ConnectionDB.openConnection();
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_get_all_reviews()}");
            rs = cs.executeQuery();

            while (rs.next()) {
                Review r = new Review(
                        rs.getString("idReview"),
                        rs.getString("idUser"),
                        rs.getString("idProduct"),
                        rs.getString("comment"),
                        rs.getInt("rating")
                );
                list.add(r);
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
    public Review getReviewById(String id) {
        Review r = null;
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_get_review_by_id(?)}");
            cs.setString(1, id);
            rs = cs.executeQuery();

            if (rs.next()) {
                r = new Review(
                        rs.getString("idReview"),
                        rs.getString("idUser"),
                        rs.getString("idProduct"),
                        rs.getString("comment"),
                        rs.getInt("rating")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return r;
    }

    @Override
    public boolean insertReview(Review review) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_insert_review(?,?,?,?,?)}");
            cs.setString(1, review.getIdReview());
            cs.setString(2, review.getIdUser());
            cs.setString(3, review.getIdProduct());
            cs.setString(4, review.getComment());
            cs.setInt(5, review.getRating());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean updateReview(Review review) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_update_review(?,?,?,?,?)}");
            cs.setString(1, review.getIdReview());
            cs.setString(2, review.getIdUser());
            cs.setString(3, review.getIdProduct());
            cs.setString(4, review.getComment());
            cs.setInt(5, review.getRating());

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cs);
        }
        return false;
    }

    @Override
    public boolean deleteReview(String id) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = getConnection();
            cs = conn.prepareCall("{call sp_delete_review(?)}");
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


