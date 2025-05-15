package com.example.ss9.dao;
import com.example.ss9.model.Movie;
import com.example.ss9.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public List<Movie> getAllMovies() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Movie> movies = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_movies()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("language")
                );
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return movies;
    }

    @Override
    public Movie getMovieById(Long id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Movie movie = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_movie_by_id(?)}");
            callSt.setLong(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                movie = new Movie(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("director"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getInt("duration"),
                        rs.getString("language")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return movie;
    }
}