package com.example.ss11.controller.bt7;

import com.example.ss11.dto.ReviewForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {

    @GetMapping("/review")
    public String showForm(Model model) {
        model.addAttribute("reviewForm", new ReviewForm());
        return "/bt7/review-form";
    }

    @PostMapping("/review")
    public String submitReview(
            @Valid @ModelAttribute("reviewForm") ReviewForm form,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/bt7/review-form";
        }
        return "/bt7/review-success";
    }
}


