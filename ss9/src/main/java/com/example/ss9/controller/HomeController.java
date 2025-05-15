package com.example.ss9.controller;

import com.example.ss9.service.MovieService;
import com.example.ss9.service.MovieServiceImpl;
import com.example.ss9.service.ScheduleService;
import com.example.ss9.service.ScheduleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final MovieService movieService = new MovieServiceImpl();
    private final ScheduleService scheduleService = new ScheduleServiceImpl();

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "home";
    }

    @GetMapping("/detailMovie")
    public String showMovieDetails(@RequestParam("id") Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        model.addAttribute("schedules", scheduleService.findAllSchedulesByMovie(movieService.getMovieById(id).getTitle()));
        return "detailMovie";
    }
}