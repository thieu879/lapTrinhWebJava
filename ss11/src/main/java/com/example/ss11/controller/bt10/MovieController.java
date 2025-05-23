package com.example.ss11.controller.bt10;

import com.example.ss11.model.Movie;
import com.example.ss11.service.CloudinaryService;
import com.example.ss11.service.bt10.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class MovieController {
    private final MovieService movieService;
    private final CloudinaryService cloudinaryService;

    @Autowired
    public MovieController(MovieService movieService, CloudinaryService cloudinaryService) {
        this.movieService = movieService;
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping("/movies")
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "/bt10/listMovie";
    }

    @GetMapping("/addMovie")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "/bt10/addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/bt10/addMovie";
        }
        if (movie.getPosterFile() == null || movie.getPosterFile().isEmpty()) {
            result.rejectValue("posterFile", "error.movie", "Poster is required");
            return "/bt10/addMovie";
        }
        try {
            String posterUrl = cloudinaryService.uploadImage(movie.getPosterFile());
            if (posterUrl == null) {
                model.addAttribute("error", "Failed to upload poster");
                return "/bt10/addMovie";
            }
            movie.setPoster(posterUrl);
            if (movieService.addMovie(movie)) {
                return "redirect:/movies";
            } else {
                model.addAttribute("error", "Failed to add movie");
                return "/bt10/addMovie";
            }
        } catch (IOException e) {
            model.addAttribute("error", "Failed to upload poster: " + e.getMessage());
            return "/bt10/addMovie";
        }
    }

    @GetMapping("/editMovie")
    public String showEditMovieForm(@RequestParam("id") Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            model.addAttribute("error", "Movie not found");
            return "/bt10/listMovie";
        }
        model.addAttribute("movie", movie);
        return "/bt10/editMovie";
    }

    @PostMapping("/editMovie")
    public String updateMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/bt10/editMovie";
        }
        try {
            if (movie.getPosterFile() != null && !movie.getPosterFile().isEmpty()) {
                String posterUrl = cloudinaryService.uploadImage(movie.getPosterFile());
                if (posterUrl == null) {
                    model.addAttribute("error", "Failed to upload poster");
                    return "/bt10/editMovie";
                }
                movie.setPoster(posterUrl);
            } else {
                Movie existingMovie = movieService.getMovieById(movie.getId());
                movie.setPoster(existingMovie.getPoster());
            }
            if (movieService.updateMovie(movie)) {
                return "redirect:/movies";
            } else {
                model.addAttribute("error", "Failed to update movie");
                return "/bt10/editMovie";
            }
        } catch (IOException e) {
            model.addAttribute("error", "Failed to upload poster: " + e.getMessage());
            return "/bt10/editMovie";
        }
    }

    @GetMapping("/deleteMovie")
    public String deleteMovie(@RequestParam("id") Long id, Model model) {
        if (movieService.deleteMovie(id)) {
            return "redirect:/movies";
        } else {
            model.addAttribute("error", "Failed to delete movie");
            model.addAttribute("movies", movieService.getAllMovies());
            return "/bt10/listMovie";
        }
    }
}
