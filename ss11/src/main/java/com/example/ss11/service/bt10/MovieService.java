package com.example.ss11.service.bt10;

import com.example.ss11.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    boolean addMovie(Movie movie);
    boolean updateMovie(Movie movie);
    boolean deleteMovie(Long id);
}
