package com.example.ss9.service;

import com.example.ss9.dao.MovieDAO;
import com.example.ss9.dao.MovieDAOImpl;
import com.example.ss9.model.Movie;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final MovieDAO movieDAO = new MovieDAOImpl();

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieDAO.getMovieById(id);
    }
}