package com.example.ss9.dao;

import com.example.ss9.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
}