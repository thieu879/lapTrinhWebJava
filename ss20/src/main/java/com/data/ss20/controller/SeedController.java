package com.data.ss20.controller;

import com.data.ss20.config.CloudinaryService;
import com.data.ss20.entity.Seed;
import com.data.ss20.service.SeedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class SeedController {
    private final SeedService seedService;
    private final CloudinaryService cloudinaryService;

    public SeedController(SeedService seedService, CloudinaryService cloudinaryService) {
        this.seedService = seedService;
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping("/seeds")
    public String showSeeds(Model model) {
        model.addAttribute("seeds", seedService.getSeeds());
        return "seeds";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("seed", new Seed());
        return "seed-form";
    }

    @PostMapping("/add")
    public String addSeed(@Valid @ModelAttribute Seed seed,
    @RequestParam(value = "imageFile", required = false) MultipartFile fileImage
    ) {
        try {
            if (fileImage != null && !fileImage.isEmpty()) {
                String imageUrl = cloudinaryService.uploadImage(fileImage);
                seed.setImage(imageUrl);
            }
            seedService.saveSeed(seed);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/seeds";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("seed", seedService.getSeedById(id));
        return "seed-form";
    }

    @PostMapping("/edit")
    public String editSeed(@Valid @ModelAttribute Seed seed,
    @RequestParam(value = "imageFile", required = false) MultipartFile fileImage
    ) {
        try {
            if (fileImage != null && !fileImage.isEmpty()) {
                String imageUrl = cloudinaryService.uploadImage(fileImage);
                seed.setImage(imageUrl);
                seedService.updateSeed(seed);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/seeds";
    }

    @GetMapping("/delete/{id}")
    public String deleteSeed(@PathVariable Long id) {
        seedService.deleteSeed(id);
        return "redirect:/seeds";
    }

    @GetMapping("/search")
    public String searchSeeds(@RequestParam String keyword, Model model) {
        model.addAttribute("seeds", seedService.searchSeeds(keyword));
        return "seeds";
    }
}

