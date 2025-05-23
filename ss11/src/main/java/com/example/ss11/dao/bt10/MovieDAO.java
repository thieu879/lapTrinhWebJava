package com.example.ss11.dao.bt10;

import com.example.ss11.model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    boolean addMovie(Movie movie);
    boolean updateMovie(Movie movie);
    boolean deleteMovie(Long id);
}
